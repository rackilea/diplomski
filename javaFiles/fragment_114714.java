private void initGUI() {
    Image orange = getOrangeImage();
    Image apple = getAppleImage();
    // ...

    Map<String, Icon> icons = new HashMap<>();
    icons.put("orange", new ImageIcon(orange));
    icons.put("apple", new ImageIcon(apple));
    // ...

    JList<String> list = new JList<>(new String[] { "orange", "apple", "banana" });
    list.setCellRenderer(new FruitRenderer(icons));
    // ...
}

class FruitRenderer extends DefaultListCellRenderer {

    private final Map<String, Icon> icons;

    FruitRenderer(Map<String, Icon> icons) {
        this.icons = Objects.requireNonNull(icons);
    }

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index,
            boolean isSelected, boolean cellHasFocus) {

        Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof String) {
            Icon icon = icons.get(value);
            ((JLabel) comp).setIcon(icon);
        }
        return comp;
    }
}