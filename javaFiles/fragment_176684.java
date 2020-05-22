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

                JLabel label = new JLabel("Hello new world");
                label.setSize(label.getPreferredSize());
                label.setLocation(0, 0);
                dialog.getLayeredPane().add(label, new Integer(1));

                dialog.setSize(100, 100);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

                System.exit(0);
            }
        });
    }
}