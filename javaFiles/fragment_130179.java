public class ChessSquare extends JPanel{
    int x,y;

    public ChessSquare(int x, int y){
        super();
        this.setPreferredSize(new Dimension(50,50));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.x = x;
        this.y = y;
    }
}