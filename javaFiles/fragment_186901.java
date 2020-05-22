import java.util.Observable;
import java.util.Observer;
public class So44075321 {
    enum Piece {
        vacant,knight,bishop;
    }
    static class Game extends Observable implements Observer {
        Game() {
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    board[i][j]=Piece.vacant;
            addObserver(this);
        }
        @Override public String toString() {
            StringBuffer stringBuffer=new StringBuffer();
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++)
                    stringBuffer.append(board[i][j]+" ");
                stringBuffer.append('\n');
            }
            return stringBuffer.toString();
        }
        void move(int i,int j,int k,int l) {
            Piece piece=board[i][j];
            board[i][j]=Piece.vacant;
            board[k][l]=piece;
            setChanged();
            notifyObservers();
        }
        final int n=3;
        Piece[][] board=new Piece[n][n];
        @Override public void update(Observable o,Object arg) {

            System.out.println("update: "+toString());
        }
    }
    public static void main(String[] args) {
        Game game=new Game();
        game.board[0][0]=Piece.knight;
        System.out.println(game);
        game.move(0,0,1,1);
    }
}