byte[] bodyarr = toByteArr(response.getEntity().getContent());
    byte[] boundary = "*************boundary>>****************".getBytes();

    ByteArrayInputStream bis = new ByteArrayInputStream(bodyarr);
    MultipartStream stream;

    stream = new MultipartStream(bis,boundary);     

    boolean hasNextPart = stream.skipPreamble();

    while (hasNextPart) {
        String header=stream.readHeaders();
        String name = getNameFromHeader(header);

        //if data is image 
        FileOutputStream outputStream = new  FileOutputStream(name+".png");
        stream.readBodyData(outputStream);

        hasNextPart = stream.readBoundary();

    }