public class Main {

/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    final JDialog dia = new JDialog();
    JButton btn = new JButton("Foo");
    btn.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent ae) {
            dia.setVisible(false);
            Runnable t = new Runnable() {
                public void run() {
                    System.out.println("foo");
                }
            };
            t.run();
        }
    });
    dia.getContentPane().add(btn);
    dia.setSize(500, 400);
    dia.setVisible(true);
}
}