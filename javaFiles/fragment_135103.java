import java.applet.Applet;
import java.awt.*;
import java.net.*;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class GrabThatCanvas {

    GrabThatCanvas() {
        try {
            String string = "http://mainline.brynmawr.edu/Courses/cs110/spring2002/Applets/Smiley/";
            URL[] urls = {
                    new URL(string)
            };
            URLClassLoader urlcl = new URLClassLoader(urls);
            Class<?> clss = urlcl.loadClass("Smiley");
            Object o = clss.newInstance();
            Applet applet = (Applet)o;
            applet.init();
            applet.start();
            applet.setPreferredSize(new Dimension(200,200));

            Canvas canvas = findFirstCanvas(applet);
            if (canvas!=null) {
                System.out.println("We have the Canvas!");
            } else {
                System.out.println("No Canvas found!");
            }

            JOptionPane.showMessageDialog(null, applet);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* Very naive implementation that assumes the canvas is added
     * directly to the applet. */
    public Canvas findFirstCanvas(Container parent) {
        Canvas canvas = null;
        Component[] components = parent.getComponents();
        for (Component c : components) {
            System.out.println(c);
            if (c instanceof Canvas) {
                canvas = (Canvas)c;
                break;
            }
        }
        return canvas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GrabThatCanvas();
            }
        });
    }
}