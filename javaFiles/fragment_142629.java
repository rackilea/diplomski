if (JOptionPane.showConfirmDialog(this, jp, "Accuracy", 
        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, icon)  == 0) {
    valueSelected = jc.getSelectedItem().toString();
    System.out.println("Accuracy Selected Is: " + valueSelected);
}
else {
    System.out.println("Input Canceled");
}