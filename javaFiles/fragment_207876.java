public class Game extends JFrame {

public Game() throws HeadlessException {
    setSize(100, 100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    setVisible(true);
}

private javax.swing.JButton jButton1;
private javax.swing.JPanel jPanel1;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea jTextArea1;
private javax.swing.JTextField jTextField1;

void init() {

    jButton1 = new JButton("jButton1");

    jTextArea1 = new JTextArea("jTextArea1");
    jTextField1 = new JTextField("jTextField1");
    JPanel panel2 = new JPanel();
    panel2.setLayout(new FlowLayout());
    panel2.add(jTextField1);
    panel2.add(jButton1);
    jPanel1 = new JPanel();
    jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.Y_AXIS));
    jPanel1.add(jTextArea1);
    jPanel1.add(panel2);
    jScrollPane1 = new JScrollPane(jPanel1);
    setContentPane(jScrollPane1);
    System.out.println("init");
    revalidate();
}

public static void main(String[] args) throws InterruptedException {
    Game g = new Game();
    //wait just to find the effect of revalidate
    Thread.sleep(1000);

    g.init();
}