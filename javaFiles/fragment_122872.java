public File[] showOpenDialog(Component parent, String title) {
    JDialog dialog = new JDialog(parent == null ? null : SwingUtilities.getWindowAncestor(parent), title);
    dialog.setModal(true);
    frameSetup(dialog);

    ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            //..
            dialog.dispose();
        }
    };
    dynamicChooser.addActionListener(listener);

    dialog.pack();
    dialog.setLocationRelativeTo(parent);

    dialog.setVisible(true);
    dynamicChooser.removeActionListener(listener);

    return dynamicChooser.getSelectedFiles();
}