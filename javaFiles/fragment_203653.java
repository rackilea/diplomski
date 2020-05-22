import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import java.awt.peer.WindowPeer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

@SuppressWarnings("serial")
public class MyFrame extends Frame implements WindowListener {

    final Image i16, i24, i32, i48;

    MyFrame() throws Exception {

        i16 = Toolkit.getDefaultToolkit().getImage("Icon16x16.png");
        i24 = Toolkit.getDefaultToolkit().getImage("Icon24x24.png");
        i32 = Toolkit.getDefaultToolkit().getImage("Icon32x32.png");
        i48 = Toolkit.getDefaultToolkit().getImage("Icon48x48.png");

        addWindowListener(this);
        setSize(500,300);
        setTitle("Unaliased icon example");
        setLayout(new FlowLayout());
        setVisible(true);
    }

    public synchronized void customSetIconImages(java.util.List<Image> icons) throws Exception {
        Field windowIcons = Class.forName("java.awt.Window").getDeclaredField("icons");
        windowIcons.setAccessible(true);
        windowIcons.set(this, new ArrayList<Image>(icons));

        if (getPeer() != null)
            updateIconImages(i24, 24, 24, i24, 24, 24);

        firePropertyChange("iconImage", null, null);
    }

    public void updateIconImages(Image big, int bw, int bh, Image small, int sw, int sh) throws Exception {
        DataBufferInt iconData = getUnscaledIconData(big, bw, bh);
        DataBufferInt iconSmData = getUnscaledIconData(small, sw, sh);

        WindowPeer peer = (WindowPeer) getPeer();
        Method setIconImagesData = Class.forName("sun.awt.windows.WWindowPeer").getDeclaredMethod("setIconImagesData", int[].class, int.class, int.class, int[].class, int.class, int.class);
        setIconImagesData.setAccessible(true);
        setIconImagesData.invoke(peer, iconData.getData(), bw, bh, iconSmData.getData(), sw, sh);
    }

    public static DataBufferInt getUnscaledIconData(Image image, int w, int h) {
        Image temporary = new ImageIcon(image).getImage();
        BufferedImage buffImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffImage.createGraphics();
        g2d.drawImage(temporary, 0, 0, null);
        g2d.dispose();
        Raster raster = buffImage.getRaster();
        DataBuffer buffer = raster.getDataBuffer();
        return (DataBufferInt) buffer;
    }

    @Override
    public void windowOpened(WindowEvent arg0) {
        try {
            customSetIconImages(Arrays.asList(i24));
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+" "+e.getMessage());
        }
    }

    @Override
    public void windowActivated(WindowEvent arg0) {
    }

    @Override
    public void windowClosed(WindowEvent arg0) {
    }

    @Override
    public void windowClosing(WindowEvent arg0) {
        dispose();
    }

    @Override
    public void windowDeactivated(WindowEvent arg0) {
    }

    @Override
    public void windowDeiconified(WindowEvent arg0) {
    }

    @Override
    public void windowIconified(WindowEvent arg0) {
    }

    public static void main(String args[]) throws Exception {
        MyFrame fr = new MyFrame();
    }
}