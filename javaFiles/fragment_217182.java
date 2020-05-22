Component[] comps = gridPanel.getComponents();
for (Compoent comp : comps) {
    if (comp instanceof JComboBox) {
        JComboBox combo = (JComboBox) comp;
        Object selected = combo.getSelectedItem();
    }
}