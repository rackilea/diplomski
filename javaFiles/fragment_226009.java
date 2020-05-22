import com.jniwrapper.Function;
import com.jniwrapper.Library;
import com.jniwrapper.Parameter;
import com.jniwrapper.Pointer;
import com.jniwrapper.UInt32;
import com.jniwrapper.win32.ui.Wnd;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class TestDWM {

    public static void main(String[] args) {
        new TestDWM();
    }

    public TestDWM() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final JFrame frame = new JFrame();
                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));

                TranslucentPane panel = new TranslucentPane();
                frame.setContentPane(panel);

                panel.setBorder(new EmptyBorder(40, 40, 40, 40));

                frame.setLayout(new GridBagLayout());
                JLabel label = new JLabel("I'm a banana");
                label.setFont(label.getFont().deriveFont(Font.BOLD, 48f));
                frame.add(label);

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setAlwaysOnTop(true);
                frame.setVisible(true);

                setBlurBehind(frame);
            }
        });
    }

    public class TranslucentPane extends JPanel {

        public TranslucentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Color color = getBackground();
            color = new Color(color.getRed(), color.getGreen(), color.getBlue(), 32);
            g.setColor(color);
            g.fillRect(0, 0, getWidth(), getHeight());
        }

    }

    public static void setBlurBehind(Window window) {

        Wnd wnd = new Wnd(window);
        Library libDWMAPI = new Library("Dwmapi");
        Function fEnableBlurBehindWindow = libDWMAPI.getFunction("DwmEnableBlurBehindWindow");
        DWMBlurBehind behind = new DWMBlurBehind();

        System.out.println("wnd = " + wnd);

        UInt32 dwResult = new UInt32(0);
        long hResult = fEnableBlurBehindWindow.invoke(
                        dwResult,
                        new Parameter[]{
                            wnd,
                            new Pointer(behind)
                        });

        System.out.println("hResult = " + hResult);
        System.out.println("dwResult = " + dwResult.getValue());

    }

}