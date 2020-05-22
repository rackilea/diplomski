Path file = ...;
InputStream in = null;
StringBuffer cBuf = new StringBuffer();
try {
    in = file.newInputStream();
    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
    String line = null;

    while ((line = reader.readLine()) != null) {
        System.out.println(line);
        cBuf.append("\n");
        cBuf.append(line);
    }
} catch (IOException x) {
    System.err.println(x);
} finally {
    if (in != null) in.close();
}
// cBuf.toString() will contain the entire file contents
return cBuf.toString();