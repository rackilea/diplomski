public class ElementRunner {

    public static void main(String[] args) {
        MyWindow panel = new MyWindow();
        panel.setBackground(Color.RED);

        JFrame frame = new JFrame("Element project ~ By: Harsh Patel");
        frame.setBounds(100, 100, 600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(panel);
        frame.setVisible(true);

    }
}