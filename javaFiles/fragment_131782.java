public class SwingMenuDemo {

private JFrame mainFrame;

public SwingMenuDemo() { prepareGUI(); }

public static void main(String[] args) {
    SwingMenuDemo swingMenuDemo = new SwingMenuDemo();
    swingMenuDemo.showMenuDemo();
}

private void prepareGUI() {
    mainFrame = new JFrame("Java SWING Examples");
    mainFrame.setSize(400, 400);
    mainFrame.setVisible(true);
}

private void showMenuDemo() {
    //create a menu bar
    final JMenuBar menuBar = new JMenuBar();

    //create menus
    JMenu fileMenu = new JMenu("File");

    //create menu items
    JMenuItem test1 = new JMenuItem("test1");
    JMenuItem test2 = new JMenuItem("test2");
    JMenuItem test3 = new JMenuItem("test3");
    JMenuItem test4 = new JMenuItem("test4");

    ImageIcon i = new ImageIcon((getClass().getResource("new.png")));
    Image image = i.getImage(); // transform it
    Image newimg = image.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
    i = new ImageIcon(newimg);  // transform it back

    test4.setIcon(i);

    fileMenu.add(test1);
    fileMenu.add(test2);
    fileMenu.add(test3);
    fileMenu.add(test4);

    menuBar.add(fileMenu);

    //add menubar to the frame
    mainFrame.setJMenuBar(menuBar);
    mainFrame.setVisible(true);
  }
}