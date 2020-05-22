import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JDesktopPane dp = new JDesktopPane();
                dp.setPreferredSize(new Dimension(200, 200));

                JInternalFrame iFrame = new JInternalFrame("Test", true, true, true, true);
                iFrame.getContentPane().setPreferredSize(new Dimension(100, 100));
                iFrame.pack();
                iFrame.setVisible(true);

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(dp);
                frame.pack();
                frame.setLocationRelativeTo(null);

                dp.add(iFrame);

                Dimension desktopSize = dp.getSize();
                Dimension loginSize = iFrame.getSize();

                int x = (desktopSize.width - loginSize.width) / 2;
                int y = (desktopSize.height - loginSize.height) / 2;
                iFrame.setLocation(x, y);

                frame.setVisible(true);
            }
        });
    }

}