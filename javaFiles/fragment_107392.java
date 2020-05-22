messageBodyPart = new MimeBodyPart();
    String filename = "/home/manisha/file.txt";
    //
    // FileInputStream is just for the example. You can use other InputStreams as well.
    //
    InputStream inputStream = new FileInputStream(filename);

    DataSource source;
    try (InputStream inputStream = new FileInputStream(filename)) {
        source = new ByteArrayDataSource(inputStream, "text/plain;charset=UTF-8");
    }
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(filename);
    multipart.addBodyPart(messageBodyPart);

    // Send the complete message parts
    message.setContent(multipart);