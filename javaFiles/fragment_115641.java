public class DrawPanel extends JPanel {
  //...

  InputHandler inputHandler; // here you declare the variable 

  //...

  public DrawPanel () {
    setIgnoreRepaint(true); // why this line?
    setVisible(true); // not needed in a JPanel's code
    setFocusable(true);
    addKeyListener(inputHandler); // here you use a null variable
    addMouseListener(inputHandler); // ditto, here you use a null variable
    new InputHandler(); // I don't know what you're doing here
  }