public class Option1 extends Frame implements ActionListener {

    private int click = 0;

    public Option1() {

        JFrame base = new JFrame("Button Click Counter");
        base.getContentPane().setLayout(null);
        base.setSize(500, 500);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Click Me!");
        button.addActionListener(this);
        JTextField count = new JTextField(click);
        this.add(button);
        this.add(count);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        click++;
    }
}