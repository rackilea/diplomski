public class ChessPanel extends JPanel{
    JPanel positions[][] = new JPanel[8][8];
    ChessSquare move[] = new ChessSquare[2];

    public ChessPanel(){
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridLayout(8,8));

        for(int i=0;i<positions.length;i++){
            for(int j=0;j<positions[i].length;j++){
                ChessSquare square = new ChessSquare(i,j);
                square.addMouseListener(new MouseListener(){
                    public void mouseClicked(MouseEvent me) {
                        ChessSquare cs = (ChessSquare)me.getComponent();
                        if(isValidMove(cs)){

                            System.out.println("Valid move!");
                            System.out.println("x1: "+move[0].x+" y1: "+move[0].y);
                            System.out.println("x2: "+move[1].x+" y2: "+move[1].y);
                            System.out.println("");

                            resetMove();
                        }
                    }

                    //Other mouse events

                });
                positions[i][j] = square;
                add(square);
            }
        }
    }

    private boolean isValidMove(ChessSquare square){
        //here you would check if the move is valid.
        if(move[0] == null){
            move[0] = square;
            return false; //first click
        }else{
            move[1] = square;
        }

        //Other chess rules go here...
        return true;
    }

    private void resetMove(){
        move = new ChessSquare[2];
    }
}