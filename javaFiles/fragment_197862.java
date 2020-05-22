public static JRadioButton getSelection(ButtonGroup group) {
    for (Enumeration e = group.getElements(); e.hasMoreElements();) {
        JRadioButton b = (JRadioButton) e.nextElement();
        if (b.getModel() == group.getSelection()) {
            return b;
        }
    }
    return null;
}