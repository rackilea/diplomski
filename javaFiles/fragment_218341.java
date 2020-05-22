public enum Caracteristic {
    A("Hello World!", 1), B("easy", 2), C("medium", 3), D("hard", 4);

    private final String name;
    private final int level;
    Caracteristic(String name, int level)
    {
        this.name = name;
        this.level = level;
    }
    @Override
    public String toString() { return name; }
    public int getLevel() { return level; }
}