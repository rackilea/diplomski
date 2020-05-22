Container cont = frame.getContentPane();

Component[] components = cont.getComponents();
List<JComponent> list = new ArrayList<>();
for (Component comp : components) {
    if (comp instanceof JComponent) {
        list.add((JComponent) comp);
    }
}
for (JComponent jComponent : list) {
    jComponent.setBorder(BorderFactory.createLineBorder(Color.black,2));
}