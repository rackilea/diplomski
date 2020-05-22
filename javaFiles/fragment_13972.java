public enum Color {
    RED("R"),
    GREEN("G"),
    BLUE("B");

    private final String str;
    private Color(String s){
        str = s;
    }
    @Override
    public String toString() {
        return str;
    }
}