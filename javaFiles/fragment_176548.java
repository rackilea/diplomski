Http.MultipartFormData.FilePart<File> file = body.getFile("avatar");

 FileInputStream in = null;
  FileOutputStream out = null;
  try {
     in = new FileInputStream(file);
     //enter the file location in server
     out = new FileOutputStream("output.jpeg");

     int c;
     while ((c = in.read()) != -1) {
        out.write(c);
     }
  }finally {
     if (in != null) {
        in.close();
     }
     if (out != null) {
        out.close();
     }
  }