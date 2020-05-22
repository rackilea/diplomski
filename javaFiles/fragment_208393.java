ButtonGroup bg; // your button group
Box box; // your box
// Create a panel to group the buttons.
JPanel panel = new JPanel();
// Add all of the buttons in the group to the panel.
for (Enumeration<AbstractButton> en = buttonGroup.getElements(); en.hasMoreElements();) {
    AbstractButton b = en.nextElement();
    panel.add(b);
}
// Add the panel to the box.
box.add(panel):