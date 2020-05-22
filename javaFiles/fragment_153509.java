class MyFrame extends JFrame {
    public MyFrame() {

        JFrame myFrame = new JFrame();  

        myFrame.setLayout( new FlowLayout() );

        myFrame.add(new panels());
        myFrame.setTitle("GUI Demo - ISTE-121");
        myFrame.pack();
        myFrame.setLocation(600,300);
        myFrame.setSize(400,200);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);

    }
}

class panels extends JPanel {

   final JTextField items;
   final JTextField number;
   final JTextField cost;
   final JTextField amount;


   public panels() {
      setLayout(new GridLayout(5,5,2,2));

      add(new JLabel("Item no:", SwingConstants.RIGHT));
      add(items = new JTextField(3));

      add(new JLabel("Number of:", SwingConstants.RIGHT));
      add(number = new JTextField(3));

      add(new JLabel("Cost", SwingConstants.RIGHT));
      add(cost = new JTextField(3));

      add(new JLabel("Amount owed:", SwingConstants.RIGHT));
      add(amount = new JTextField(10));
      amount.setEditable(false);

    }
}

public class FrameTest {

    public static void main(String args[]) {
        MyFrame first = new MyFrame();
    }
}