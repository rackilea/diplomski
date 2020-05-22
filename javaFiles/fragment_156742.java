File file = new File(System.getProperty("user.home"), "one.txt");
try (PrintStream ps = new PrintStream(file)) {
    ps.println("content");
} catch (FileNotFoundException e) {
    e.printStackTrace();
}