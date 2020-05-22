private ImageIcon image;

public TestLabel100(Integer size, String name) {
    //...
    JLabel textLabel = new JLabel(name);
    textLabel.setIcon(image);
    textLabel.setHorizontalTextPosition(JLabel.CENTER);
    textLabel.setVerticalTextPosition(JLabel.SOUTH);        
    //textLabel.setBounds(100, 100, 70, 30);
    //...
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    //...