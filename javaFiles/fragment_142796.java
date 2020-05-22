JFileChooser fc;
JButton b, b1;
JTextField tf;
FileInputStream in;
Socket s;
DataOutputStream dout;
DataInputStream din;
int i;

public void actionPerformed(ActionEvent e) {
try {
    if (e.getSource() == b) {
        int x = fc.showOpenDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            fileToBeSent = fc.getSelectedFile();
            tf.setText(f1.getAbsolutePath());
            b1.setEnabled(true);
        } else {
            fileToBeSent = null;
            tf.setText(null;);
            b1.setEnabled(false);
        }
    }
    if (e.getSource() == b1) {
        send();
    }
} catch (Exception ex) {
}
}

 public void copy() throws IOException {
    File f1 = fc.getSelectedFile();
    tf.setText(f1.getAbsolutePath());
    in = new FileInputStream(f1.getAbsolutePath());
    while ((i = in.read()) != -1) {
        System.out.print(i);
    }
}

public void send() throws IOException {
    dout.write(i);
    dout.flush();

}