public class FlipperHandler implements ActionListener {
    private JButton[] buttons;
    private int[] card1, card2;

    public FlipperHandler(JButton[] buttons, int[] card1, int[] card2) {
        this.buttons = buttons;
        this.card1 = card1;
        this.card2 = card2;
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        buttons[card1[0]][card1[1]].setText("");
        buttons[card2[0]][card2[2]].setText("");     
    }
}