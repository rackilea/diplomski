public class BadPaint {

    public static void main(String[] args) {
        new BadPaint();
    }

    public BadPaint() {
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

                JFrame frame = new JFrame();
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
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.VERTICAL;
            gbc.insets = new Insets(10, 10, 10, 10);

            BackgroundPane left = new BackgroundPane();
            left.setLayout(new BorderLayout());
            JLabel label = new JLabel(" Menu ");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            left.add(label);
            add(left, gbc);

            gbc.gridx++;
            gbc.weighty = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(40, 10, 40, 10);
            BackgroundPane right = new BackgroundPane();
            right.setLayout(new BorderLayout());
            label = new JLabel(" Content ");
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setVerticalAlignment(JLabel.CENTER);
            right.add(label);
            add(right, gbc);

        }

    }

    public class BackgroundPane extends JPanel {

        public BackgroundPane() {
            setBackground(Color.GRAY);
            setBorder(new LineBorder(Color.BLACK));
        }

    }

}