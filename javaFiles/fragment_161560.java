byte[] buffer = new byte[1024];
int bytes;
String end = "<!MSG>";
StringBuilder curMsg = new StringBuilder();

while (-1 != (bytes = mmInStream.read(buffer))) {
    curMsg.append(new String(buffer, 0, bytes, Charset.forName("UTF-8")));
    int endIdx = curMsg.indexOf(end);
    if (endIdx != -1) {
        String fullMessage = curMsg.substring(0, endIdx + end.length());
        curMsg.delete(0, endIdx + end.length());
        // Now send fullMessage
    }
}