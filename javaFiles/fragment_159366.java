int opt = JOptionPane.showOptionDialog(jf, "Do you really want to?", "Confirm",
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
if(opt == JOptionPane.OK_OPTION) {
    System.out.println("Ok then!");
} else {
    System.out.println("Didn't think so.");
}