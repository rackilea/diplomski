public class Blink {
    private JPanel frame1;
    private int pause1TimesRan;
    private int pause2TimesRan;

    private Timer pauser1, pauser2;

    public Blink(Interface anInterface) {
        this.frame1 = anInterface.getFrame1();
        //Create pauser 1 with delay 200ms
        pauser1 = new Timer(200, e -> {
            if (pause1TimesRan == 10) {
                pauser1.stop();
                return;
            }
            Color color = randomColor();
            frame1.setBackground(color);
            System.out.println("Pauser #1 changed background to: " + color);
            pause1TimesRan++;
        });
        //Create pauser 2 with delay 1000ms
        pauser2 = new Timer(1000, e -> {
            if (pause2TimesRan == 10) {
                pauser2.stop();
                return;
            }
            Color color = randomColor();
            frame1.setBackground(color);
            System.out.println("Pauser #2 changed background to: " + color);
            pause2TimesRan++;
        });
    }

    private static Color randomColor() {
        return new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
    }

    public void blink() {
        pauser1.start();
        pauser2.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Interface anInterface = new Interface("Title");
            anInterface.setVisible(true);
            Blink blink = new Blink(anInterface);
            blink.blink();
        });
    }

    static class Interface extends JFrame {
        private JPanel frame1;

        public Interface(String titel) {
            super(titel);
            setSize(600, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame1 = new JPanel();
            this.frame1.setPreferredSize(new Dimension(200, 200));
            setLayout(new FlowLayout());
            add(frame1);
            this.setVisible(true);
        }

        public JPanel getFrame1() {
            return frame1;
        }

    }
}