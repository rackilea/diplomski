public class AJFrame extends JFrame {

    ImageIcon ii;

    public AJFrame() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //setVisible(true);

        //ImageIcon ii = new ImageIcon("Untitled.png");
        JPanel jp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                g.fillRect(0, 0, 50, 50);
            }
        };

        add(jp);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AJFrame().setVisible(true);
            }
        });
    }
}