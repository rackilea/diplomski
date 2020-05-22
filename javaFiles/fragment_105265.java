@Override
    public Component prepareRenderer
    (TableCellRenderer renderer, int row, int col

        ) {
                Component comp = super.prepareRenderer(renderer, row, col);
        Object value = getModel().getValueAt(row, col);
        setCellSelectionEnabled(true);

    // Here you can write you schemes in RGB
// of course you need to describe it before mathematicaly
// and using variable `row` and `col` you will have coordinates to the cells
        final Random r = new Random();
        int R = r.nextInt(Math.round(256 / (row + 1)));
        int G = r.nextInt(Math.round(256 / (col + 1)));
        int B = r.nextInt(Math.round(256 / (row + col + 1)));
        Color c = new Color(R, G, B);

        if (getSelectedRow() != 0) {
            if (row % 2 == 0 && col % 2 == 1) {
                comp.setBackground(c);
            } else if (row % 2 == 1 && row % 2 == 1) {
                comp.setBackground(c);
            } else {
                comp.setBackground(c);
            }
        } else {
            comp.setBackground(Color.white);
        }
        return comp;
    }
};