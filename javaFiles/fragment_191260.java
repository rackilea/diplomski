public void getFileContent(String fileName) {
    try( Reader reader=Files.newBufferedReader(Paths.get(fileName)) ) {
        CharBuffer buffer = CharBuffer.allocate(500 * 100000);
        while(reader.read(buffer) > 0) {
            buffer.flip();
            while(buffer.remaining()>500) {
                processData(buffer.slice().limit(500).toString());
                buffer.position(buffer.position()+500);
            }
            buffer.compact();
        }
        // there might be a remaining chunk of less than 500 characters
        if(buffer.position()>0) {
            processData(buffer.flip().toString());
        }
    } catch(Exception ex) {
        // the *minimum* to do:
        ex.printStackTrace();
        // TODO real exception handling
    }
}