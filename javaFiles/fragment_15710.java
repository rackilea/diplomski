private Map<String, JButton> dynamicButtons;

public void addButton(String name) {
    JButton b = new JButton(name);
    b.addActionListener(someAction);
    yourPanel.add(b);
    dynamicButtons.put(name, b);
    yourPanel.invalidate();
}

public void removeButton(String name) {
    Button b = dynamicButtons.remove(name);
    yourPanel.remove(b);
    yourPanel.invalidate();
}