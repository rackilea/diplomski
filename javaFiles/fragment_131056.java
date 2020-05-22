package mactest;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Rectangle;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
  public static void main(String[] args) {
    boolean modal = false;
    boolean tweak = false;
    if(args.length > 0) {
      modal = args[0].toLowerCase().equals("true");
    }
    if(args.length > 1) {
      tweak = args[1].toLowerCase().equals("true");
    }

    TestDialog dlg = new TestDialog(new Frame(), modal, tweak);

    dlg.setVisible(true);
  }

  private static class TestDialog extends Dialog {
    private Checkbox cb1;
    private Checkbox cb2;

    private CheckboxGroup cbg;

    public TestDialog(Frame owner, boolean modal, boolean tweak) {
      super(owner);

      cbg = new CheckboxGroup();

      cb1 = new Checkbox("One", true, cbg);
      cb2 = new Checkbox("Two", false, cbg);

      this.setLayout(new FlowLayout());
      this.add(cb1);
      this.add(cb2);

      this.setModal(modal);
      this.pack();

      if(tweak) {
        cb1.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            onSelection();
          }
        });
        cb2.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            onSelection();
          }
        });
      }

      this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          TestDialog.this.setVisible(false);
          System.exit(0);
        }
      });
    }

    private void onSelection() {
      Rectangle bounds = this.getBounds();
      this.setBounds(bounds.x, bounds.y, bounds.width + 1, bounds.height);
      EventQueue.invokeLater(new Runnable() {
        public void run() {
          TestDialog.this.pack();
        }
      });
    }
  }
}