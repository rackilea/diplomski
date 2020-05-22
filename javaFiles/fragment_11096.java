public class BoardFrame extends JPanel {

    public static void main(String[] args) {
        new BoardFrame();
    }

    private int rowNumber, columnNumber;
    private JFrame mainFrame;

    public BoardFrame(int m, int n) {
        rowNumber = m;
        columnNumber = n;
        mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //this.setBackground(Color.cyan); // replaces need for paintComponent
        mainFrame.add(this); // <-- added this line
        mainFrame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(0, 0, this.getWidth(), this.getHeight()); // <-- added this line
    }
}