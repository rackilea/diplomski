import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FileChooserExample {

    public static void main(String[] args) {
        new FileChooserExample();
    }

    public FileChooserExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                FileOpenDialog dialog = new FileOpenDialog(0);
                dialog.showOpenDialog(null);

            }
        });
    }

    class FileOpenDialog extends JFileChooser {

        public String fileName;
        public String dialogTitle;

        public FileOpenDialog(int index) {
            initComponent(index);
        }

        @Override
        protected JDialog createDialog(Component parent) throws HeadlessException {
            JDialog dialog = super.createDialog(parent);
            dialog.addWindowListener(new WindowAdapter() {

                @Override
                public void windowOpened(WindowEvent e) {
                    JDialog dialog = (JDialog) e.getWindow();
                    JButton button = dialog.getRootPane().getDefaultButton();
                    Point pos = button.getLocationOnScreen();
                    Dimension size = button.getSize();
                    pos.x += (size.width / 2);
                    pos.y += (size.height / 2);

                    try {
                        Robot bot = new Robot();
                        bot.mouseMove(pos.x, pos.y);
                    } catch (AWTException ex) {
                        ex.printStackTrace();
                    }
                }

            });
            return dialog;
        }

        private void initComponent(int index) {
            setBackground(Color.lightGray);
            setAcceptAllFileFilterUsed(false);

            System.out.println(getCurrentDirectory().toString() + fileName);

            File file = new File(getCurrentDirectory().toString() + fileName);
            setSelectedFile(file);
        }

        /**
         * @return the dialogTitle
         */
        @Override
        public String getDialogTitle() {
            return dialogTitle;
        }

        /**
         * @param dialogTitle the dialogTitle to set
         */
        @Override
        public void setDialogTitle(String dialogTitle) {
            this.dialogTitle = dialogTitle;
        }
    }
}