try (PrintWriter pw = new PrintWriter(new FileWriter("/tmp/pwfw.txt"))) {
    pw.append('\u2126');
    pw.println();
} catch (IOException ex) {
    System.err.println("something failed: " + ex.getMessage());
}