public class SlideShow extends JFrame {

public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            new SlideShow().setVisible(true);
        }});
}