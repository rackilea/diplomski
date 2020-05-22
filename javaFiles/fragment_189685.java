String line = null;
final BufferedReader reader =
    new InputStreamReader (process.getInputStream());
while((line = reader.readLine()) != null) {
   // Ignore line, or do something with it
}