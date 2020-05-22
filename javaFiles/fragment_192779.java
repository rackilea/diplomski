public class TestLabel01 {

    public static void main(String[] args) {
        new TestLabel01();
    }

    public TestLabel01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JLabel link = new JLabel("Linked in");
                link.setForeground(Color.BLUE);
                link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(link);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}