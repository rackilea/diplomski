public class TestLayeredDialog {

    public static void main(String[] args) {
        new TestLayeredDialog();
    }

    public TestLayeredDialog() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JDialog dialog = new JDialog();
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                dialog.setLayout(new BorderLayout());
                dialog.add(new MyContent());
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

                System.exit(0);
            }
        });
    }

    public class MyContent extends JLayeredPane {

        public MyContent() {
            JLabel label = new JLabel("Hello new world");
            label.setSize(label.getPreferredSize());
            label.setLocation(0, 0);
            add(label);

            Dimension size = getPreferredSize();

            JButton button = new JButton("Click me");
            button.setSize(button.getPreferredSize());
            button.setLocation(size.width - button.getWidth(), size.height - button.getHeight());
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(MyContent.this).dispose();
                }
            });
            add(button);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

    }

}