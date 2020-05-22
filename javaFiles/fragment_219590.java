class ImmutableIcon implements Icon {
    private Icon icon;

    public ImmutableIcon(Icon i) {
        this.icon = i;
    }

    public int getIconHeight() {
        return this.icon.getIconHeight();
    }

    public int getIconWidth() {
        return this.icon.getIconWidth();
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        this.icon.paintIcon(c, g, x, y);
    }
}