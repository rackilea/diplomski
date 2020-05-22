import javax.swing.JDialog;
import javax.swing.JFrame;

public class MyDialog {

    private JFrame frame = new JFrame();
    private JDialog dialog = new JDialog();

    public MyDialog() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
        //dialog = new JDialog(frame, JDialog.ModalityType.TOOLKIT_MODAL);
        dialog = new JDialog(frame, true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setModal(true);
        dialog.setSize(300, 200);
        dialog.setVisible(true);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                MyDialog dialog = new MyDialog();
            }
        });
    }
}