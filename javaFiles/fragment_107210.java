String absoluteFilePath = getServletContext().getRealPath(requestUri);
File file = new File(absoluteFilePath);

if (file.exists()) { 
    // ...
}