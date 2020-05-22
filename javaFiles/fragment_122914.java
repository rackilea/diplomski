public class Frame extends JFrame{
    JPanel panel1 = new JPanel();
    JButton button = new Button();
    int WIDTH=600,HEIGHT=600;

    public Frame(){
    setTitle("Halo");
    setLayout(new BorderLayout());
    add(panel1, BorderLayout.CENTER);

    panel1.setBounds(0,0,WIDTH,HEIGHT);
    panel1.setLayout(new BorderLayout());
    panel1.add(button, BorderLayout.SOUTH);
    button.setBounds(10,10,30,30);

    pack();
    setVisible(true);
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}