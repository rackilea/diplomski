public class Player {

    ...

    public int move(int distance) {
        position = position + distance;
        jar.move(distance);
    }
}


public class Jar {
    private int position;
    private Stone stone;

    public Jar() {
        position = 0;
        stone = null;
    }

    public Jar(int initPos, Stone stone) {
        position = initPos;
        this.stone = stone;
    }

     public void move(int distance) {
        position += distance;
    }
}