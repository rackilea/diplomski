import org.nlogo.lite.InterfaceComponent;
import org.nlogo.util.Utils;
import org.nlogo.api.ModelReader;

public class TestNetLogo {
  public static void main(String[] argv) {
    try {
      final javax.swing.JFrame frame = new javax.swing.JFrame();
      final InterfaceComponent comp = new InterfaceComponent(frame);
      java.awt.EventQueue.invokeAndWait(
    new Runnable() {
      public void run() {
        frame.add(comp);
        frame.setVisible(true);
        try {
          String src = Utils.url2String(ModelReader.emptyModelPath());
          // Those null's are model name and model path.
          comp.openFromSource(null, null, src);
        } catch(Exception ex) {
          ex.printStackTrace();
        }
      }});
        comp.command("create-turtles 1");
        comp.command("ask turtles [ set heading 0 \n set color [255 255 255] \n pen-down \n fd 4 ]");
    }
    catch(Exception ex) {
      ex.printStackTrace();
    }
  }
}