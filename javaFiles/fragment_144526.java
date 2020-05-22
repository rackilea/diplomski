package apptotray;

import java.awt.*;
import java.io.File;
import java.nio.file.Paths;
import javax.swing.*;

public class AppToTray {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Some Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new JPanel(), BorderLayout.CENTER);
        frame.setPreferredSize(new Dimension(500, 500));
        frame.pack();
        frame.setVisible(true);

        System.load(new File("JNI.dll").getAbsolutePath());
        try {
            System.out.println("Icon is showing..");
            Thread.sleep(3000);
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }

        removeFromTaskBar(getWindowHandle(frame));

        try {
            System.out.println("Icon is not showing..");
            Thread.sleep(3000);
        } catch (Exception Ex) {
            Ex.printStackTrace();
        }

        addToTaskBar(getWindowHandle(frame));
        System.out.println("Icon is showing again..");
    }

    public static native void addToTaskBar(long WindowHandle);

    public static native void removeFromTaskBar(long WindowHandle);

    public static long getWindowHandle(java.awt.Frame frame) {
        return (Long)invokeMethod(invokeMethod(frame, "getPeer"), "getHWnd");
    }

    protected static Object invokeMethod(Object o, String methodName) {
        Class c = o.getClass();
        for (java.lang.reflect.Method m : c.getMethods()) {
            if (m.getName().equals(methodName)) {
                try {
                    return m.invoke(o);
                } catch (IllegalAccessException | IllegalArgumentException | java.lang.reflect.InvocationTargetException Ex) {
                    Ex.printStackTrace();
                    break;
                }
            }
        }
        return null;
    }
}