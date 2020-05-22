void clearTextFields(Container container) {
    for (Component c : container.getComponents()) {
        if (c instanceof JTextField) {
           ((JTextField)c).setText("");
        } else
        if (c instanceof Container) {
           clearTextFields((Container)c);
        }
    }
}