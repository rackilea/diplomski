private static void showErrorPane(String message, String title) {
   JOptionPane pane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
   JDialog dialog = pane.createDialog(title);
   dialog.setAlwaysOnTop(true);
   dialog.setVisible(true);
}