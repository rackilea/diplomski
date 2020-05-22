public enum AnotherEnum {
    ONE(1, "un"), TWO(2, "deux"), THREE(3, "trois"), FIFTY_SEVEN(57, "cinquante-sept");

    private final int someInt;
    private final String french;
    private AnotherEnum(int i, String s) {
        this.someInt = i;
        this.french = s;
    }
    public int getSomeInt() {
        return this.someInt;
    }
    public String getFrench() {
        return this.french;
    }
}