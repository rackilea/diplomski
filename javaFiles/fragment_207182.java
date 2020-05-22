public class CriminalPic extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    InputStream is = null;
    OutputStream os = response.getOutputStream();
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "epolicia", "admin");
       PreparedStatement ps = con.prepareStatement("select * from CRIMINAL_PIC where CRIMINAL_ID = ?");
        String id = request.getParameter("id");
        ps.setString(1,id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Blob  b = rs.getBlob("PICTURE");
        response.setContentType("image/jpeg");
        response.setContentLength( (int) b.length());
        is = b.getBinaryStream();
        byte buf[] = new byte[(int) b.length()];
        is.read(buf);
        os.write(buf);
    }
    catch(Exception ex) {
        File file = new File(getServletContext.().getRealPath("/pics/thief.jpg"));
        FileInputStream fis = new FileInputStream(file);
        int bytes;
        while ((bytes = fis.read()) != -1) {
        os.write(bytes);
        }
    }