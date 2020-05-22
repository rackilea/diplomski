public static void main(String[] args) {
    JTextField fileName = new JTextField();
    Object[] message = {"File name", fileName.getText()};//send text of filename
    String option = JOptionPane.showInputDialog(null, message, "Add New", JOptionPane.OK_CANCEL_OPTION);
    System.out.println(fileName.getText());
}