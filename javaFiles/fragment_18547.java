final File TEST_FILE = new File("D:/my_text.txt");
    //final DiskFileItem diskFileItem = new DiskFileItem("fileData", "text/plain", true, TEST_FILE.getName(), 100000000, TEST_FILE);
    try
    {
        DiskFileItem fileItem = (DiskFileItem) new DiskFileItemFactory().createItem("fileData", "text/plain", true, TEST_FILE.getName());
        InputStream input =  new FileInputStream(TEST_FILE);
        OutputStream os = fileItem.getOutputStream();
        int ret = input.read();
        while ( ret != -1 )
        {
            os.write(ret);
            ret = input.read();
        }
        os.flush();
        System.out.println("diskFileItem.getString() = " + fileItem.getString());
    }
    catch (Exception e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }