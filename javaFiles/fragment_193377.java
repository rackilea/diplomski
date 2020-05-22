public class Main {
    public static void main(String[] args) {
        SwingUtiliites.invokeLater(new Runnable(){
            public void run() {
                JFrame frame  = new JFrame();
                frame.add(new DrawPanel());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}