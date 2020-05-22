JOptionPane optionPane = new JOptionPane("Do you really want to?",
        JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
JDialog dialog = optionPane.createDialog(jf, "Confirm");

dialog.setVisible(true);
dialog.dispose();

int opt = (int) optionPane.getValue();
if(opt == JOptionPane.OK_OPTION) {
    System.out.println("Ok then!");
} else {
    System.out.println("Didn't think so.");
}