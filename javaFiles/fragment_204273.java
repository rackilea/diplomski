public TestFileIO() {
    try {
        writeUser(new File("User.inf"), "Test", "Password".toCharArray());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}

public void writeUser(File file, String name, char[] password) throws IOException {
    BufferedWriter bw = null;
    try {
        bw = new BufferedWriter(new FileWriter(file));
        bw.write(name);
        bw.write(";");
        bw.write(password);
        bw.flush();
    } finally {
        try {
            bw.close();
        } catch (Exception e) {
        }
    }
}