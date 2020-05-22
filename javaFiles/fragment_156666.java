public class View extends JFrame {

public View() {

    JFrame frame = new JFrame("Equation");
    frame.getContentPane().setLayout(new BorderLayout());

    JPanel panel1 = new JPanel();
    panel1.setPreferredSize(new Dimension(50, 50));

    JLabel labelA = new JLabel();
    labelA.setText("a");
    JTextField textA = new JTextField("0",3);
    JLabel labelB = new JLabel();
    labelB.setText("b");
    JTextField textB = new JTextField("0",3);
    JLabel labelC = new JLabel();
    labelC.setText("c");
    JTextField textC = new JTextField("0",3);

    JButton draw = new JButton();
    draw.setText("Draw");
    draw.addActionListener( new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            Controller.a = Double.parseDouble(textA.getText());
            Controller.b = Double.parseDouble(textB.getText());
            Controller.c = Double.parseDouble(textC.getText());

            repaint();
            frame.pack();
            frame.setSize(420,490);
        }
    });

    panel1.add(labelA);
    panel1.add(textA);
    panel1.add(labelB);
    panel1.add(textB);
    panel1.add(labelC);
    panel1.add(textC);
    panel1.add(draw);

    JPanel panel2 = new JPanel(){

        public void paint(Graphics g){
            super.paint(g);
            Controller.grid(g);
            Controller.Graphic1(g);
        }                                  
    };

    panel2.setBackground(Color.WHITE);

    frame.getContentPane().add(panel1, BorderLayout.PAGE_START);
    frame.getContentPane().add(panel2, BorderLayout.CENTER);

    frame.setVisible(true);
    frame.setSize(420,490);
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                View frame = new View();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}
}