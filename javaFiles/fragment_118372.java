public class MainAc extends JFrame {

public static void main(String[] args) {
    new MainAc();
}

public MainAc() {
    super("Class Paint");       
    JButton button = new JButton("Click for more");             
    setSize(800, 600);    
    add(button);
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    button.setLayout(null);
    button.setLocation(100,100);
    button.setSize(200,100);
    setVisible(true);
}

public void paint(Graphics g) {
    super.paint(g);
    g.drawString("Hello", 200, 50);
}

}