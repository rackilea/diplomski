public class Player {
    private String name;
    private int position;
    private static Jar jar;
    private Stone stone;
    private Ground ground;

    public String toString()  {
        return name + "[" + stone + "]"  + "(" + position + ")";
    }

    public void setStone(Stone s) {
        stone = s;
    }
}