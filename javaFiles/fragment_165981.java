public class MyWindow extends JPanel implements KeyListener {

    private static final long serialVersionUID = 1L;
    private JTextField textBox;
    private String textInput;

    public MyWindow() {
        textInput = "";
        textBox = new JTextField("Enter symbol here:", 30);
        textBox.addKeyListener(this); // This line adds the listener to the TextField
        this.add(textBox);
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.CYAN);
        g.drawString("Enter element symbol in text box above.", 110, 50);
        g.drawString(textInput, 100, 100);
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_ENTER) {
            textInput = textBox.getText();
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) { }
}