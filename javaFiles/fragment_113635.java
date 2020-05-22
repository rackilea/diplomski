import javax.swing.*;

class FrameLook {

    public static void showFrame(String plaf) {
        try {
            UIManager.setLookAndFeel(plaf);
        } catch(Exception e) {
            e.printStackTrace();
        }
        JFrame f = new JFrame(plaf);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        f.setSize(400,100);
        f.setLocationByPlatform(true);
        f.setDefaultLookAndFeelDecorated(true);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        showFrame(UIManager.getSystemLookAndFeelClassName());
        showFrame(UIManager.getCrossPlatformLookAndFeelClassName());
        showFrame("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    }
}