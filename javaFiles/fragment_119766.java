package swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class ComboBox {
  ImageIcon imageIcon[] = { new ImageIcon("/images/g.jpg"), new ImageIcon("/images/g.jpg"), 
      new ImageIcon("/images/g.jpg"), new ImageIcon("/images/g.jpg"), new ImageIcon("/images/g.jpg") };
  Integer array[] = {1,2,3,4,5};
  String names[] = {"img1","img2","img3","img4","img5"};
  public ComboBox() {
    JFrame.setDefaultLookAndFeelDecorated(true);
    JFrame frame = new JFrame("ComboBOx");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container con = frame.getContentPane();

    ComboBoxRenderar rendrar = new ComboBoxRenderar();

    JComboBox box = new JComboBox(array);

    box.setRenderer(rendrar);
    con.add(box);

    con.setLayout(new FlowLayout());

    frame.setVisible(true);
    frame.pack();
  }
  public class ComboBoxRenderar extends JLabel implements ListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, 
                                                  Object value, 
                                                  int index, 
                                                  boolean isSelected, 
                                                  boolean cellHasFocus) {
      int offset = ((Integer)value).intValue() - 1 ;

      ImageIcon icon = imageIcon[offset];
      String name = names[offset];

      setIcon(icon);
      setText(name);

      return this;
    }


  }
  public static void main(String args[]) {
    new ComboBox();
  }
}