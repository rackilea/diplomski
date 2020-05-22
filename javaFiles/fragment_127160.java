public static void main(String[] args) throws Exception {
    JOptionPane pane1 = new JOptionPane();
    JDialog dialog1 = pane1.createDialog(null, "Window1");
    dialog1.setModal(false);
    dialog1.setVisible(true);

    JOptionPane pane2 = new JOptionPane();
    JDialog dialog2 = pane2.createDialog(null, "Window2");
    dialog2.setModal(false);
    dialog2.setVisible(true);
}