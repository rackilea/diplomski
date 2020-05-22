String partialLine="";
public static String monitorResponse() throws Exception {
    System.out.println("Listening for a response...");
    int nextByte;
    String nextChar;
    while (inputStream.ready()) {
        nextByte = inputStream.read();
        nextChar = Character.toString ((char) nextByte);
        partialLine += nextChar;
        if ("\n".equals(nextChar)) {
            String line = partialLine;
            partialLine = "";
            return line.replace("\r\n", "");
        }
    }
    return "";
}