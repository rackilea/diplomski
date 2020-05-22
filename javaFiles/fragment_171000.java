public class Block {
    private String name;
    private int x;
    private int y;
    private List<Line> lines = new ArrayList<>();

    public Block(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    @Override
    public String toString() {
        return "Block [name=" + name + ", x=" + x + ", y=" + y + ", lines=" + lines + "]";
    }

}