public class Toolbar extends JPanel {

    public void addAction(Action action) {
        add(new JButton(action));
    }

}