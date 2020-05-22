FileService fileService = FileServiceFactory.getFileService();
    AppEngineFile readableFile = new AppEngineFile("your_file_name");
    FileReadChannel readChannel = fileService.openReadChannel(readableFile,
            false);
    InputStream input = Channels.newInputStream(readChannel);

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(input);

    Element root = doc.getDocumentElement();

    Element firstName = doc.createElement("first-name");
    firstName.setTextContent("content");

    root.appendChild(firstName);
    // Now write
    GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder()
            .setBucket("mybucket").setKey("myfile")
            .setMimeType("text/html").setAcl("public_read")
            .addUserMetadata("myfield1", "my field value"); // change as
                                                            // your need
    AppEngineFile writableFile = fileService.createNewGSFile(optionsBuilder
            .build());
    FileWriteChannel writeChannel = fileService.openWriteChannel(
            writableFile, false);
    OutputStream output = Channels.newOutputStream(writeChannel);

    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    DOMSource source = new DOMSource(doc);
    transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    StreamResult result = new StreamResult(output);
    transformer.transform(source, result);