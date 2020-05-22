public class TestFocusTransversal {

    public static void main(String[] args) {
        new TestFocusTransversal();
    }

    public TestFocusTransversal() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ButtonPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        FocusManager.getCurrentKeyboardFocusManager().focusNextComponent();
                    }
                });
                timer.setRepeats(true);
                timer.setCoalesce(true);
                timer.start();

            }

        });
    }

    public class ButtonPane extends JPanel {

        public ButtonPane() {
            setLayout(new GridLayout(3, 2));
            FocusHandler focusHandler = new FocusHandler();
            ActionHandler actionHandler = new ActionHandler();
            for (int index = 0; index < 6; index++) {
                JButton button = new JButton("Button " + index);
                button.addActionListener(actionHandler);
                button.addFocusListener(focusHandler);
                add(button);
            }
        }

    }

    public class FocusHandler extends FocusAdapter {

        @Override
        public void focusGained(FocusEvent e) {
            try {
                Robot bot = new Robot();
                Component component = e.getComponent();
                Point pos = component.getLocationOnScreen();
                bot.mouseMove(pos.x + (component.getWidth() / 2), pos.y + (component.getHeight() / 2));
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }

    }

    public class ActionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = ((JButton)e.getSource());
            System.out.println("Fired " + button.getText());
        }
    }

}