public class Main {

    public static void main(String[] args) {

        // Creating the Game 
        ChessGame chessGame = new ChessGame();

        // Creating the Human Player 
        //Human Player is the Object chessGui
        ChessGui chessGui = new ChessGui(chessGame);
        //Creating the A.I's
        SimpleAiPlayerHandler ai1 = new SimpleAiPlayerHandler(chessGame);//Super Dumb
        SimpleAiPlayerHandler ai2 = new SimpleAiPlayerHandler(chessGame);//Dumb
        SimpleAiPlayerHandler ai3 = new SimpleAiPlayerHandler(chessGame);//Not So Dumb

        // Set strength of AI, how far they can see ahead 
        ai1.maxDepth = 1;
        ai1.maxDepth = 2;
        ai3.maxDepth = 3;

        //Assign the Human to White 
        chessGame.setPlayer(Piece.COLOR_WHITE, chessGui);

        //////////// JCombobox

        String[] comboTypes = { "ai1", "ai2", "ai3" };
        // Create the combo box, and set 2nd item as Default
        JComboBox comboTypesList = new JComboBox(comboTypes);
        comboTypesList.setSelectedIndex(2);
        comboTypesList.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JComboBox jcmbType = (JComboBox) e.getSource();
                String cmbType = (String) jcmbType.getSelectedItem();

                if(cmbType.equals("ai1"))
                   chessGame.setPlayer(Piece.COLOR_BLACK, ai1);
                else if(cmbType.equals("ai2"))
                   chessGame.setPlayer(Piece.COLOR_BLACK, ai2);
                else
                  chessGame.setPlayer(Piece.COLOR_BLACK, ai3);
                startGame(chessGame);
            }
        });




    }

    public void startGame(ChessGame chessGame){
        new Thread(chessGame).start();
    }

}