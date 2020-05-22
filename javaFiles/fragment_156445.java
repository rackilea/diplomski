try {
      HttpSession session=request.getSession();
      String applicationNumber = (String)session.getAttribute("APPREFNUMBER");
      File file = new File("C:/photos/"+applicationNumber+".jpg");
      if (file.exists()) {
         BufferedInputStream in = new BufferedInputStream(
                                new FileInputStream(file));

         // Get image contents.
        byte[] bytes = new byte[in.available()];
        in.read(bytes);
        in.close();
         // Write image contents to response.
        response.getOutputStream().write(bytes);
          }
} catch (IOException e) {
        e.printStackTrace();
    }