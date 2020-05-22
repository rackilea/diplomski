public class Coord {

private int[] coord;

public Coord(int x, int y) {
    coord = new int[2];
    coord[0] = x;
    coord[1] = y;
}

public void printX(){
    System.out.println("X = " + coord[0] );
}

public void printY(){
    System.out.println("Y = " + coord[1] );
}

public static void main(String[] args) {
    Coord c1 = new Coord(10, 11);
    Coord c2 = new Coord(23, 14);
}
}