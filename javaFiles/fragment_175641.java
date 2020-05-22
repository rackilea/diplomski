private final JFrame frame = new JFrame("myBoardGame");
private JPanel contentPane = new JPanel(new BorderLayout());
private JPanel timerPane = new JPanel(new FlowLayout());

public ShowBoard(Board board){
    timerPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    contentPane.add(timerPane, BorderLayout.NORTH);
    contentPane.add(board, BorderLayout.CENTER);

    frame.setResizable(false);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frame.setContentPane(contentPane);
    frame.pack();
    frame.setVisible(true);

    this.board = board;
    getKeyBindings(); 
}