public class AutoClose02 {

    public static void main(String[] args) {
        new AutoClose02();
    }

    private Timer timer;
    private JLabel label;
    private JFrame frame;

    public AutoClose02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JOptionPane op = new JOptionPane("Breaktime", JOptionPane.WARNING_MESSAGE);
                final JDialog dialog = op.createDialog("Break");
                dialog.setAlwaysOnTop(true);
                dialog.setModal(true);
                dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                // Wait for 1 minute...
                timer = new Timer(60 * 1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        dialog.dispose();
                    }
                });
                timer.setRepeats(false);
                // You could use a WindowListener to start this
                timer.start();

                dialog.setVisible(true);
            }
        }
        );
    }

}