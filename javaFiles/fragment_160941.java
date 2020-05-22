public class MainApp {
    public static void main(String... args) {
        EventQueue.invokeLater(
            new Runnable() {
                @Override
                public void run() {
                    JFrame frame= new YourFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            }
        );
    }
}

class YourFrame () extends JFrame implements ActionListener{
    public YourFrame() {
    }

    public void showGUI(BufferedImage img){
    }

    private void add(JButtob button) {
    }
}