import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GUITest extends JFrame {

  private JLabel label;
  private JLabel label2;
  private JLabel label3;
  private JButton Load;
  private JButton Edit;
  private JButton Delete;
  private int x = 0, y = 0, z = 0;


  public GUITest() {
    setLayout(new FlowLayout());

    Load = new JButton("Load");
    add(Load);

    Edit = new JButton("Edit");
    add(Edit);

    Delete = new JButton("Delete");
    add(Delete);

    label = new JLabel("");
    add(label);

    label2 = new JLabel("");
    add(label2);

    label3 = new JLabel("");
    add(label3);

    event1 e1 = new event1();
    Load.addActionListener((ActionListener) e1);

    event2 e2 = new event2();
    Edit.addActionListener((ActionListener) e2);

    event3 e3 = new event3();
    Delete.addActionListener((ActionListener) e3);

  }

  public class event1 implements ActionListener {
    public void actionPerformed(ActionEvent e) {

      if(x == 0) {
        label.setText("Load file");
        x = 1;
      } else if(x == 1) {
        label.setText("");
        x = 0;
      }

    }
  }

  public class event2 implements ActionListener {
    public void actionPerformed(ActionEvent ev) {
      if(y == 0) {
        label2.setText("Edit file");
        y = 1;
      } else if(y == 1) {
        label2.setText("");
        y = 0;
      }
    }

  }

  public class event3 implements ActionListener {
    public void actionPerformed(ActionEvent eve) {
      if(z == 0) {
        label3.setText("Delete file");
        z = 1;
      } else if(z == 1) {
        label3.setText("");
        z = 0;
      }
    }
  }


  public static void main(String args[]) {
    GUITest gui = new GUITest();
    gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    gui.setVisible(true);
    gui.setSize(600, 200);
    gui.setTitle("BASIC GUI");
  }
}