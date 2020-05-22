public static void main(String[] args){
    try {
        Board board = new Board();
        board.display();
        board.validate();
    } catch (... exp) {
        exp.printStackTrace();
    }
}