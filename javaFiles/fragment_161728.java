public class TimerTest {

    static Timer timer = new Timer(10, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("test");

        }

    });

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //Run in EDT
            timer.start();
        });
    }
}