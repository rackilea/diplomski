public class Main extends JFrame{

  //initialize integer height/width values along with declaring 
  //Swing component variables
  private final int W = 500,
                    H = 500;

  private JMenu file, headMenu, bgMenu;
  private JMenuBar menuBar;
  private JMenuItem exitItem;

  //constructor
  public Main(){
    setTitle("Move the Head");
    setSize(W, H);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    initializeElements();

  }

  //Initializes the elements, this part is missing from your code above.
  public void initializeElements(){

    menuBar = new JMenuBar();
    file = new JMenu("File");
    exitItem = new JMenuItem("Exit");

    exitItem.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ev) {
        System.exit(0);
      }
    });

    headMenu = new JMenu("Heads");
    bgMenu = new JMenu("Backgrounds");

  }

  public static void main( String[] args ) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Main f = new Main();
            f.setVisible(true);
        }
    });
  }
}