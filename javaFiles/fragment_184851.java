import javax.swing.*;
import java.awt.*;

public class TableHeaderExample {
  private JFrame jFrame;

  public TableHeaderExample() {
    jFrame = new JFrame();
  }

  private void setLookAndFeel() {
    try {
      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
      //Do not use below.
//      UIManager.setLookAndFeel(
//              "com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public void createTableWithColorHeader() {
    setLookAndFeel();
    String data[][] = {{"Sambit", "23", "1000"}, {"John", "25", "200"}};
    String column[] = {"EMP NAME", "EMP AGE", "EMP SALARY"};
    JTable jTable = new JTable(data, column);
    jTable.getTableHeader().setBackground(Color.blue);
    jTable.setBounds(30, 40, 200, 300);
    JScrollPane sp = new JScrollPane(jTable);
    jFrame.add(sp);
    jFrame.setSize(300, 400);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
  }


  public static void main(String[] args) {
    TableHeaderExample example = new TableHeaderExample();
    example.createTableWithColorHeader();
  }
}