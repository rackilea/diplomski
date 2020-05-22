ByteArrayOutputStream out = new ByteArrayOutputStream();
int counter;
byte[] buffer = new byte[1024]; // Let's read up to 1KB at a time, it's faster
while((counter = is.read(buffer)) != -1)
    out.write(buffer, 0, counter);

// String output = new String(out.toByteArray(), "UTF-8");
String output = out.toString("UTF-8"); // Save an extra byte[] allocation