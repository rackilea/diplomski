public class RobotTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RobotTest().create();
            }
        });
    }

    private void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());
        f.add(new JTextField(8));
        final JButton b = new JButton();
        f.getRootPane().setDefaultButton(b);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                b.setText("@" + e.getWhen());
            }
        });
        f.add(b);
        f.setSize(256, 128);
        f.setVisible(true);
        doTest();
    }

    private void doTest() {
        try {
            Robot r = new Robot();
            int[] keys = {
                KeyEvent.VK_T, KeyEvent.VK_E,
                KeyEvent.VK_S, KeyEvent.VK_T,
                KeyEvent.VK_Z, KeyEvent.VK_BACK_SPACE,
                KeyEvent.VK_ENTER
            };
            for (int code : keys) {
                r.keyPress(code);
                r.keyRelease(code);
            }
        } catch (AWTException ex) {
            ex.printStackTrace(System.err);
        }
    }
}