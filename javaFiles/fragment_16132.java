public class timeTest extends javax.swing.JFrame {

  SimpleDateFormat date_format = new SimpleDateFormat("MMM dd, yyyy HH:mm:ss");

    public timeTest() {
        initComponents();
        showTime();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new timeTest().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel timeLable;

    private void showTime() {
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Calendar time = Calendar.getInstance();
                timeLable.setText(date_format.format(time.getTime()));
            }
        });
        timer.setRepeats(true);
        timer.start();
    }
}