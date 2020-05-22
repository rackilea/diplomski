// in wrapper:
modifyJChooser(fileChooser.getComponents(), Color.white);

// in component:
private void modifyJChooser(Component[] jc, Color bg) {

    for (int i = 0; i < jc.length; i++) {
        Component c = jc[i];

        // hide file name selection
        if (c.getClass().getSimpleName().equals("MetalFileChooserUI$3")) {
            c.getParent().setVisible(false);
        }

        if (c instanceof JComboBox) {
            Object sel = ((JComboBox) c).getSelectedItem();
            if (sel.toString().contains("AcceptAllFileFilter")) {
                c.setVisible(false);
            }
        } else if (c instanceof JLabel) {
  // **** This is the part that the original poster is looking for ****
            String text = ((JLabel) c).getText();
            if (text.equals("Files of Type:") || text.equals("File Name:") || text.equals("Folder Name:")) {
                c.getParent().getParent().remove(c.getParent());
            }
        } else if (c instanceof JButton) {
            JButton j = (JButton) c;
            String txt = j.getText();
            if (txt != null) {
                if (JCHOOSER_NEW_FOLDER.equalsIgnoreCase(txt)) {
                    j.getParent().setVisible(false); // Disable New Folder on Mac OS
                } else if (JCHOOSER_BTN_CANCEL.equalsIgnoreCase(txt)) {
                    Component parent = c.getParent();
                    ((Container) parent).remove(c);
                }
            }
        }

        if (c instanceof Container)
            modifyJChooser(((Container) c).getComponents(), bg);

        c.setBackground(bg);
    }

}