InputStream stream = socket.getInputStream();
StringBuilder builder = new StringBuilder();
do {
    byte [] buffer = new byte[256];
    int bytes = stream.read(buffer);
    builder.append(new String(buffer, 0, bytes));
} while ((builder.length() < 10));
String completeStr = builder.toString();