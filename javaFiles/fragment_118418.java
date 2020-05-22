public abstract class Piece {
    public abstract void move();
}

public class SlowPiece extends Piece {
    public void move() {
        System.out.println("moving a slow piece");
    }
}

public class FastPiece extends Piece {
    public void move() {
        System.out.println("moving a fast piece");
    }
}

Piece f = new FastPiece();
f.move();       

Piece s = new SlowPiece();
s.move();