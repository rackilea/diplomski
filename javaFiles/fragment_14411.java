File sourceFile = ...
File targetFile = ...
BufferedReader in = new BufferedReader(new InputStreamReader(
        new FileInputStream(sourceFile), "ISO-8859-6"));
BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
        new FileOuputStream(targetFile), "UTF-8"));
for (;;) {
    String line = in.readLine();
    if (line == null) {
        break;
    }
    out.write(line);
    out.write("\r\n"); // Windows CR+LF.
}
out.close();
in.close();