public class MyPanel extends JPanel {
    public MyPanel(int x, int y) {
        setLayout(new MigLayout("wrap " + x));

        JButton[][] buttons = new JButton[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                buttons[i][j] = new JButton("a" + i + j);
                add(buttons[i][j]);
            }
        }
    }
}