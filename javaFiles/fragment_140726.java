byte[] valueFromTextField = "hello world foo bar".getBytes();
StringBuilder builder = new StringBuilder();
int i = 0;
for (byte element : valueFromTextField) {
    if (i % 4 == 0 && builder.length() > 0) {
        builder.append(" ");
    }
    builder.append(String.format("%02x", element));
    i++;
}
System.out.println(builder.toString());