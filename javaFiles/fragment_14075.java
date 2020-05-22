ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "mysql -p -h localhost test < "+fileName.toString());
builder.redirectErrorStream(true);
Process pr = builder.start();

// Get mysql process's standard output/error.
InputStream is = pr.getInputStream();

// Now read from it and write it to standard output.
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
String line = reader.readLine();
while (line != null) {
    System.out.println(line);
    line = reader.readLine();
}