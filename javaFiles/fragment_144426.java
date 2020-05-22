/*
<applet code='ParamApplet' width='200' height='200'>
<param name='param' value='foo'>
</applet>
*/
import java.applet.*;
import javax.swing.*;
import java.net.URL;
import java.util.HashMap;

public class ParamApplet extends JApplet {

    public void init() {
        String param = getParameter("param");
        System.out.println("parameter: " + param);
        add(new JLabel(param));
    }

    public static void main(String[] args) {
        ApplicationAppletStub stub = new ApplicationAppletStub();
        stub.addParameter(args[0], args[1]);
        ParamApplet pa = new ParamApplet();
        pa.setStub(stub);

        pa.init();
        pa.start();
        pa.setPreferredSize(new java.awt.Dimension(200,200));
        JOptionPane.showMessageDialog(null, pa);
    }
}

class ApplicationAppletStub implements AppletStub {

    HashMap<String,String> params = new HashMap<String,String>();

    public void appletResize(int width, int height) {}
    public AppletContext getAppletContext() {
        return null;
    }

    public URL getDocumentBase() {
        return null;
    }

    public URL getCodeBase() {
        return null;
    }

    public boolean isActive() {
        return true;
    }

    public String getParameter(String name) {
        return params.get(name);
    }

    public void addParameter(String name, String value) {
        params.put(name, value);
    }
}