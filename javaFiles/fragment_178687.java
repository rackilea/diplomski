import java.lang.ref.WeakReference;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Test {

public static void main(String[] args) throws Throwable {
    WeakReference<JDialog> ref = test();

    Runtime.getRuntime().gc();
    System.out.println(ref.get()==null? "collected": "still flying around");
  }

  public static WeakReference<JDialog> test() throws Throwable {
      JDialog d = new JDialog(new JFrame());
      WeakReference<JDialog> ref = new WeakReference<JDialog>(d);
      d.setVisible(true);
      d.dispose();
      d.getOwner().dispose();
      return ref;
  }
}