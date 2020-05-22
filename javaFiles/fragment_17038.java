public class Swing extends JPanel {

    private JButton button;
    private JLabel label;

    public Swing() {
        creatButton();
        add(button);
    }

    public void creatButton() {
        JButton btn = new JButton("click me");
    }
}