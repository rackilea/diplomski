import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {

  public Menu() {
    super("MLA Formatter");
    JButton b1 = new JButton("Export File");
    b1.setVerticalTextPosition(AbstractButton.CENTER);
    b1.setHorizontalTextPosition(AbstractButton.CENTER);

//Layout 1
//Default layout of JFrame content pane is BorderLayout.
//When we do not specify a constraint (like BorderLayout.SOUTH), default is BorderLayout.CENTER
//So, this is equivalent to add(b1, BorderLayout.CENTER);
    //add(b1);

//Layout 2
    //add(b1, BorderLayout.SOUTH);

//Layout 3
    //setLayout(new FlowLayout());
    //add(b1);

//Layout 4
    setLayout(new GridBagLayout());
    add(b1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.SOUTH,
        GridBagConstraints.NONE, new Insets(10, 10, 10, 10), 0, 0));
  }

  public static void main(String[] args) {
    Menu window = new Menu();
    window.setBounds(200, 200, 1000, 800);
    window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    window.setVisible(true);
  }
}