public class TicTacToe extends JFrame implements ActionListener {
    private JButton[][] cells = new JButton[3][3];
    private char turn = 'X';
    private boolean playing;

    public TicTacToe() {
        setTitle("TicTacToe");
        setSize(new Dimension(400, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        createCells();
        pack();
    }