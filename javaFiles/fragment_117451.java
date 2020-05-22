DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> files = new ServletFileUpload(factory).parseRequest(request);

for (FileItem item : files) {
    if (item.isFormField()) {
        String fieldname = item.getFieldName();
        String fieldvalue = item.getString();
        if (fieldname.compareTo("Mcheckbox") == 0) {
            System.out.println("checkbox value is " + fieldvalue);
            mymobilepass = fieldvalue;
        } else if (fieldname.compareTo("Echeckbox") == 0) {
            System.out.println("checkbox value is " + fieldvalue);
            myemailpass = fieldvalue;
        }

    } else {
        InputStream is = item.getInputStream();

        FileOutputStream fos = new FileOutputStream(path + "\\" + fi.getName());
        int x = is.read();

        while (x >= 0) {
            fos.write((byte) x);
            x = is.read();
            //System.out.println("reading");

        }
    }
}