int rows = // number of rows in 2D array
int cols = // number of cols in 2D array
final JLabel[][] labels = new JLabel[rows][cols]
MouseListener ml = new MouseAdapter() {
    public void mousePressed(MouseEvent me) {
        Object src = me.getSource();
        int x = -1;
        int y = -1;
        for (int i = 0; i < labels.length(); i++) {
            for (int j = 0; j < labels[i].length; j++) {
                if (src == labels[i][j]) {
                    x = i;
                    y = j;
                    break;
                }
            }
            if (x >= 0) {
                break;
            }
        }
        if (x > 0) {
            System.out.printf("JLabel[%d][%d] was clicked.%n", x, y);
        }
        else {
            System.out.println("Could not find clicked label.");
        }
    }
}
for (int row = 0; row < rows; row++) {
    for (int col = 0; col < cols; col++) {
        labels[row][col] = new JLabel(row + "," + col);
        labels[row][col].addMouseListener(ml);
    }
}