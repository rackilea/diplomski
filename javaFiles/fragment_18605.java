public class SelectionBoardCls{
        public static void boardSelection(String selectionBoard) //Setting up the board
{ 
    if(selectionBoard.contains("1")){ //3x3
        char[][] board= new char[3][3];
        for(int i=0;i<3;i++){
            for(int o=0;o<3;o++){
                board[i][o]='X';
            }
        }


        System.out.println(" ___________________");
        System.out.println("|     |      |      |");
        System.out.println("|  "+board[0][0]+"  |  "+board[0][1]+"   |  "+board[0][2]+"   |  ");
        System.out.println("|     |      |      |");
        System.out.println("|-------------------|");
        System.out.println("|     |      |      |");
        System.out.println("|  "+board[1][0]+"  |  "+board[1][1]+"   |  "+board[1][2]+"   |  ");
        System.out.println("|     |      |      |");
        System.out.println("|-------------------|");
        System.out.println("|     |      |      |");
        System.out.println("|  "+board[2][0]+"  |  "+board[2][1]+"   |  "+board[2][2]+"   |  ");
        System.out.println("|     |      |      |");
        System.out.println(" -------------------");     
}
}

    public static void main(String[] args) {
            String selectionBoard = "some1111";
            SelectionBoardCls.boardSelection(selectionBoard);
    }
    }