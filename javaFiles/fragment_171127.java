public class BingoMain implements ActionListener { //I ADDED THE LISTENER HERE

    private static final int ROWS = 5;
    private static final int COLS = 5;
    private static final int MAX_BINGO = 15 * COLS;     //15*5 = 75. Max number of bingo numbers
    private JMenuItem fileMenu1 = new JMenuItem("Play");
    private JMenuItem fileMenu2 = new JMenuItem("Quit");

    public BingoMain() {

        //Ask for how number of players, take the input, parse it, create that many bingo cards
        String players = JOptionPane.showInputDialog(null, "How many players? (1 to 5 players)");
        int playerNums= Integer.parseInt(players);

        JFrame myBingoGUI=new JFrame(); //frame
        myBingoGUI.setSize(900, 400);
        myBingoGUI.setLocation(100, 100);
        myBingoGUI.setTitle("BINGO");
        myBingoGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container myContentPane = myBingoGUI.getContentPane();

        JMenuBar bar = new JMenuBar();  //create menu bar
        JMenu fileMenu = new JMenu("File"); //create the file item in the bar

        bar.add(fileMenu);

        fileMenu.add(fileMenu1);
        fileMenu.add(fileMenu2);
        myBingoGUI.setJMenuBar(bar);

        fileMenu1.addActionListener(this);     //ERROR!
        fileMenu2.addActionListener(this);     //Same error
        //...
    }

    /**
     * @param args
     *
     */
    public static void main (String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BingoMain main = new BingoMain();
            }
        });

    } // main

}