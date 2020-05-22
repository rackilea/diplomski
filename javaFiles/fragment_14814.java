// we need this as there is no convenient method to output a platform
// specific line separator charcater(s)
String newLine = System.getProperty("line.separator");
try (FileWriter fw = new FileWriter("/tmp/fw.txt")) {
    fw.append('\u2126').append(newLine);
    fw.write(65);
    fw.append(newLine);
    fw.append(String.format("%10s: %s%n", "some", "value"));
    fw.append("some line").append(newLine);
} catch (IOException ex) {
    System.err.println("something failed: " + ex.getMessage());
}
// the println() methods will append the right platform specific line separator
// charcater(s)
try (PrintWriter pw = new PrintWriter("/tmp/pw.txt", "UTF8")) {
    pw.append('\u2126');
    pw.println();
    pw.write(65);
    pw.println();
    pw.printf("%10s: %s%n", "some", "value");
    pw.println("some line");
} catch (FileNotFoundException | UnsupportedEncodingException ex) {
    System.err.println(ex.getMessage());
}