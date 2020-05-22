public class ButtonsLayout {

    public static void main(String[] args) {
        new ButtonsLayout();
    }

    public ButtonsLayout() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new MenuPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MenuPane extends JPanel {

        public MenuPane() {
            setLayout(new GridBagLayout());

            JButton singleplayerButton = new JButton("SinglePLayer");
            JButton multiplayerButton = new JButton("MultiPlayer");
            JButton optionsButton = new JButton("Options");
            JButton quitButton = new JButton("Quit");

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.ipadx = 20;
            gbc.ipady = 20;

            add(singleplayerButton, gbc);
            gbc.gridy++;
            add(multiplayerButton, gbc);
            gbc.gridy++;
            add(optionsButton, gbc);
            gbc.gridy++;
            add(quitButton, gbc);
        }
    }
}