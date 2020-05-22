public class Point {
    private int x;
    private int y;

    public void flip() {
        int tmp = x;
        x = -y;
        y = -tmp;
    }
}