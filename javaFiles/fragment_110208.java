String fileName = "foo.snap";

// write a snappy compressed file
try (OutputStream os = new SnappyOutputStream(new FileOutputStream(fileName))) {
    os.write("Hello Snappy-World".getBytes(Charset.defaultCharset()));
}

// read a snappy compressed file
try (InputStream is = new SnappyInputStream(new FileInputStream(fileName))) {
    byte[] bytes = new byte[100];
    is.read(bytes);
    System.out.println(new String(bytes, Charset.defaultCharset()));
}

// check if the file is compressed with the snappy algorithm
try (InputStream is = new FileInputStream(fileName)) {
    SnappyCodec readHeader = SnappyCodec.readHeader(is);
    if (readHeader.isValidMagicHeader()) {
        System.out.println("is a Snappy compressed file");
        System.out.printf("%s: %d%n%s: %d%n", 
                "compatible version", readHeader.compatibleVersion,
                "version", readHeader.version
        );
    } else {
        System.out.println("is not a Snappy compressed file");                
    }
}