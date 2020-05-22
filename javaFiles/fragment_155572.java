import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class OpenFileTest {

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            final JDialog dlg = new javax.swing.JDialog(null, "test", JDialog.ModalityType.DOCUMENT_MODAL);
            dlg.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            JButton button = new JButton("Select Me");
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        java.awt.Desktop.getDesktop().open(
                                new java.io.File("/home/user/Downloads/jfreechart-1.0.13-US.pdf"));
                        dlg.toBack();
                    } catch (IOException e1) {
                        throw new RuntimeException(e1);
                    }
                }
            });
            dlg.add(button);
            dlg.setVisible(true);
        }
    });
}
}