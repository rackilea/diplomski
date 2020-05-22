import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class AWTScratch {
    public static void main(String[] args) {
        BufferedImage im = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
        TrayIcon ti = new TrayIcon(im, "Multiline\nmulti");
        ti.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ti.setImageAutoSize(true);
        if (SystemTray.isSupported()){
            SystemTray st=SystemTray.getSystemTray();
            try {
                st.add(ti);
            } catch (AWTException e1) {
                e1.printStackTrace();
            }
        }
    }
}