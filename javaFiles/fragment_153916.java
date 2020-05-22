public class Q2Main {

public static void main(String[] args) {
    // here we are just setting out the window end putting the circles drawin in Q2Circles into this window.
    JFrame window = new JFrame();
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setSize(1000, 500);
    window.getContentPane().add(new Q2Circles(5));
    window.setVisible(true);
}}