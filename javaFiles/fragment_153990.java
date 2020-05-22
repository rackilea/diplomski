private class MyMouse extends MouseAdapter {
    @Override
    public void mousePressed(MouseEvent e) {
        JPanel source = (JPanel) e.getSource();

        // initially set row and column to -1
        int r = -1;
        int c = -1;

        // iterate through the grid finding out which cell is source
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == source) {
                    r = row;
                    c = col;
                    break;
                }
            }
        }
        Color color = source.getBackground();

        System.out.printf("Cell: [%d, %d] color white: %b%n", c, r, color.equals(Color.WHITE));
    }
}