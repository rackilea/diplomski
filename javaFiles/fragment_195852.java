File file = new File("test.log");
PrintStream ps = new PrintStream(file);
try {
    // something
} catch (Exception ex) {
    ex.printStackTrace(ps);
}
ps.close();