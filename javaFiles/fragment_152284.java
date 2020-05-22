public class DialPanel extends JPanel {
    DialPanel(){
         setLayout(new GridLayout(3, 3));
         setBackground(Color.gray);
         JButton one = new JButton("1");
         JButton two = new JButton("2");
         JButton three = new JButton("3");
         JButton four = new JButton("4");
         JButton five = new JButton("5");
         JButton six = new JButton("6");
         JButton seven = new JButton("7");
         JButton eight = new JButton("8");
         JButton nine = new JButton("9");
         add(one);
         add(two);
         add(three);
         add(four);
         add(five);
         add(six);
         add(seven);
         add(eight);
         add(nine);
    }
}