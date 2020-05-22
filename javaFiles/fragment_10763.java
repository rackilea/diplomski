public void writeNewUser() {
    try (BufferedWriter bw = new BufferedWriter(new PrintWriter("users.txt"))) {
        bw.write(tfUsername.getText());
        bw.newLine();
        bw.write(tfPassword.getText());
    } catch (IOException e) {
        e.printStackTrace();

    }
}