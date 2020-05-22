GridFSDBFile file = files.findOne("file");

    InputStream inputStream = file.getInputStream();

    long actuallySkipped = inputStream.skip(numberOfBytesToSkip);
    // read from here...