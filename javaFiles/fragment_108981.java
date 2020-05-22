ByteArrayDataSource ds = new ByteArrayDataSource (response.getEntity().getContent(), "multipart/mixed");
    MimeMultipart multipart = new MimeMultipart(ds);  
for (int i = 0; i < multipart.getCount(); i++) {
    BodyPart bodyPart = multipart.getBodyPart(i);

    System.out.println("body : " + bodyPart.getFileName());
    System.out.println("body : " + bodyPart.getContentType());

    DataHandler handler = bodyPart.getDataHandler();
    System.out.println("handler : " + handler.getName());
    System.out.println("handler : " + handler.getContentType());



    String curContentType = handler.getContentType();

    if (curContentType.equalsIgnoreCase("application/json")) {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        handler.writeTo(arrayOutputStream);
        System.out.println("projectsJson : " + arrayOutputStream);
    } else {
        OutputStream outputStream = null;
        String ext = "";
        if (curContentType.equalsIgnoreCase("image/gif")) {
            ext = ".gif";
        } else if (curContentType.equalsIgnoreCase("image/jpeg")) {
            ext = ".jpg";
        }else if (curContentType.equalsIgnoreCase("image/png")) {
            ext = ".png";
        } else if (curContentType.equalsIgnoreCase("image/bmp")) {
            ext = ".bmp";
        } else if (curContentType.equalsIgnoreCase("application/pdf")
                || (curContentType.equalsIgnoreCase("application/x-pdf"))) {
            ext = ".pdf";
        }

        outputStream = new FileOutputStream(handler.getName()+ext);
        handler.writeTo(outputStream);
        outputStream.flush();
        outputStream.close();

    }
}