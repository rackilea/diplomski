public static void main(String[] args) {
    final Object thingIWantToUse = "Hello";

    JButton button = new JButton("Click");
    button.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        System.out.println(thingIWantToUse);
      }
    });

    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());
    frame.add(button);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }