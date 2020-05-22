System.out.printf("[Starter#main] !\n");
final ProcessBuilder builder = new ProcessBuilder("absolute/path_to/your/executable");
builder.redirectErrorStream(true);
builder.environment().put("LD_LIBRARY_PATH",
    "/usr/local/cuda/lib64:/usr/local/cuda/lib");
final Process start = builder.start();
final InputStream outputStream = start.getInputStream();
final BufferedReader reader = new BufferedReader(new InputStreamReader(outputStream));
String s;
while ((s = reader.readLine()) != null) {
    System.out.printf("[Starter#main] %s\n", s);
}