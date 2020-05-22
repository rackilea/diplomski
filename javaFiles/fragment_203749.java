public Main () {
   JFrame mainWindow = new JFrame("Main Window");
   mainWindow.setSize(1200, 800);
   mainWindow.setTitle("Main Window");
   mainWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
   mainWindow.setVisible(true);

  JButton button = new JButton("Click Me");
  mainWindow.add(button);
  button.addActionListener(this);
}