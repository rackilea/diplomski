public class ButtonPane extends JPanel {

    private JButton[][] btns;

    public ButtonPane() {
        setLayout(new GridLayout(3, 3));
        btns = new JButton[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                btns[row][col] = new JButton(row + "x" + col);
                add(btns[row][col]);
            }
        }
    }

    public JButton getButtonAt(int row, int col) {
        return btns[row][col];
    }

}