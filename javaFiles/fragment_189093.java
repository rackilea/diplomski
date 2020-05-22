class TrackCellRenderer extends DefaultTableCellRenderer {

    HashMap<String, Color> colorMap = new HashMap<>();
    Random r = new Random();

    @Override
    public Component getTableCellRendererComponent(
            JTable table,
            Object value,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component c = super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        JLabel l = (JLabel) c;

        String s = (String) value;
        if (column == 0) {
            if (!colorMap.containsKey(s)) {
                Color clr = new Color(
                        150 + r.nextInt(105),
                        150 + r.nextInt(105),
                        150 + r.nextInt(105));
                colorMap.put(s, clr);
            }
            Color color = colorMap.get(s);
            l.setBackground(color);
            l.setOpaque(true);
        } else {
            l.setOpaque(false);
        }

        return l;
    }
}