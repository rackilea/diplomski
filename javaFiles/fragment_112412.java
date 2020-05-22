public class Main extends JFrame {

JPanel upPanel = new JPanel();
JPanel newMidPanel = new JPanel();
JPanel downPanel = new JPanel();
JButton button = new JButton("add new Panel");

Main() {
    this.setSize(800, 600);
    this.setLayout(new BorderLayout());
    JPanel midPanel = new JPanel(new BorderLayout());
    this.add(upPanel, BorderLayout.PAGE_START);
    JScrollPane jsp = new JScrollPane(midPanel);
    this.add(jsp);
    this.add(downPanel, BorderLayout.PAGE_END);
    this.newMidPanel = new JPanel(new GridLayout(0, 1, 3, 3));
    upPanel.add(button);
    midPanel.add(newMidPanel, BorderLayout.NORTH);
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            newMidPanel.add(new MyPanel());
            newMidPanel.updateUI();

        }
    });
}

public static void main(String[] args) {
    new Main().setVisible(true);
}
}

class MyPanel extends JPanel {

MyPanel() {
    this.setLayout(new GridLayout(2, 5, 5, 5));
    this.setBorder(BorderFactory.createRaisedBevelBorder());

    this.add(new JLabel("Nomo:"));
}
}