public class ColorChooser extends JFrame implements ActionListener {

    JRadioButton bt1;//declare

    public static void main(String[] args) {
        new ColorChooser();
    }

    public ColorChooser() {
        super("ColorChooser");
        Container content = getContentPane();
        content.setBackground(Color.white);
        content.setLayout(new FlowLayout());
        bt1 = new JRadioButton("Red");//initializing
        JRadioButton bt2 = new JRadioButton("Yellow");

        bt1.addActionListener(this);
        bt2.addActionListener(this);
        content.add(bt1);
        content.add(bt2);
        setSize(300, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bt1) {
            getContentPane().setBackground(Color.RED);
        } else {
            getContentPane().setBackground(Color.YELLOW);
        }

    }

}