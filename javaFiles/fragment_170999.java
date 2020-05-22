public class Line {
    private int x;
    private int y;
    private List<String> names  = new ArrayList<>();

    public Line(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addName(String name) {
        names.add(name);
    }

    @Override
    public String toString() {
        return "Line [x=" + x + ", y=" + y + ", names=" + names + "]";
    }

}