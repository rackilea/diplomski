public void writeNewUser() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
        bw.write(tfUsername.getText());
        bw.newLine();
        bw.write(tfPassword.getText());
        bw.newLine();
    } catch (IOException e) {
        e.printStackTrace();

    }
}