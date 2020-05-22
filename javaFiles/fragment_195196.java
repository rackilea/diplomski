private static Map<String, FileData> fileAccess;

private class FileData {
    String userName;
    Date timeStamp = new Date();;
    String fileName;
    FileData(String userName, String fileName) {
        this.userName = userName;
        this.fileName= fileName;
    }
}

public void init(ServletConfig config) {
    String attributeKey = "fileAccess";
    fileAccess = config.getServletContext().getAttribute(attributeKey);
    if (fileAccess == null) {
        fileAccess = new HashMap<String, FileData>();
        config.getServletContext().setAttribute(attributeKey, fileAccess);
    }
}

// in this example a POST means a user accesses a file
public void doPost(HttpServletRequest req, HttpServletResponse resp) {

    // get the user name from the current session
    String userName = req.getSession().getAttribute("userName");

    // get the file name from the request (posted from the file access form)
    String fileName = req.getParameter("fileName");

    // check if we have the necessary data
    if (userName == null || fileName == null) {
        resp.getWriter().write("Invalid file access request");
        resp.getWriter().flush();    
        return;
    }

    // create and fill file data wrapper
    FileData fileData = new FileData(userName, fileName);

    // store the file data in the shared fileAccess map.
    // synchronized to block simultaneous acccess from different threads
    synchronized (fileAccess) {
        // note: any previously stored FileData object gets replaced
        fileAccess.put(fileName, fileData);
    }

    // display the result to the user
    display(fileData, resp);
}

// in this example a GET means a user views a file
public void doGet(HttpServletRequest req, HttpServletResponse resp) {

    // get the file name parameter from the request (sent as part of the view-file request)
    String fileName = req.getParameter("fileName");

    // check if we have the necessary data
    if (fileName == null) {
        resp.getWriter().write("Invalid view file request.");
        resp.getWriter().flush();    
        return;
    }

    // get the file data from the shared fileAccess map.
    // synchronized to block simultaneous acccess from different threads
    synchronized (fileAccess) {
        FileData  fileData = fileAccess.get(fileName);   

        // display the result to the user
        display(fileData, resp);
    }
}

private void display(FileData fileData, HttpServletResponse resp) {
    resp.getWriter().write("File accessed:");
    resp.getWriter().write("User: " + fileData.userName);
    resp.getWriter().write("File: " + fileData.fileName);
    resp.getWriter().write("Timestamp: " + fileData.timeStamp);
    resp.getWriter().flush();  
}