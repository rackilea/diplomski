public class MyFrame extends JFrame {

    int x;
    int y;

    MyFrame(int width, int height, int x, int y) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("R and Ts Main Frame");
        setSize(width, height);
        this.x = x;
        this.y = y;
        setLocation(x, y);

        JLabel label = new JLabel("Random Message");
        label.setFont(new Font("Impact", Font.BOLD | Font.PLAIN, height / 3));
        label.setForeground(Color.BLUE);
        getContentPane().add(label);
    }
}