Class.forName("oracle.jdbc.driver.OracleDriver");

DiskFileItemFactory factory = new DiskFileItemFactory();
// Set memory threshold - beyond which files are stored in disk 
factory.setSizeThreshold(1024*1024); // 1Mb
// Set temporary location to store files
factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

ServletFileUpload upload = new ServletFileUpload(factory);

try (Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle123")) {
    String id = null;
    InputStream photo = null;
    int photoSize = 0;

    for (FileItem item : upload.parseRequest(request)) {

        if (item.isFormField()) {
                if (item.getFieldName().equals("id")) {
                    id = item.getString();
                }
        } else {
            if (item.getFieldName().equals("user_file")){
                photo = item.getInputStream();
                photoSize = item.getSize();
            }
        }
    }

    assert (id!=null);
    assert (photo!=null);

    try (PreparedStatement pre = c.prepareStatement("insert into PHOTOS (id,photo) values(?,?)")) {
        pre.setString(1,id);
        pre.setBinaryStream(2,item.getInputStream(),item.getSize());
        pre.executeUpdate();
    }
}