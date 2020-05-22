public void writeNewUser() {      
    PrintWriter fw = null;
    try {
        fw = new PrintWriter("users.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(tfUsername.getText());
        bw.newLine();
        bw.write(tfPassword.getText());
    } catch (IOException e) {
        e.printStackTrace();
        fw.close();
    }
}