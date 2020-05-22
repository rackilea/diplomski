JColorChooser chooser = new JColorChooser(Color.BLACK);
AbstractColorChooserPanel[] panels = chooser.getChooserPanels();
for (int i = 0; i < panels.length; i++) {
    if (!panels[i].getDisplayName().equalsIgnoreCase("Swatches")) {
        chooser.removeChooserPanel(panels[i]);
    } else {
        panels[i].setBackground(new Color(0, 155, 228));
        // placing code to change recent panel background color here
        // will not work for some odd reason
        // JComponent component = (JComponent) panels[i].getComponent(0);
        // component.setBackground(new Color(0, 155, 228));
    }
}
AbstractColorChooserPanel panel = chooser.getChooserPanels()[0];
JComponent component = (JComponent) panel.getComponent(0);
component.setBackground(new Color(0, 155, 228));