public class Test {
    public static void main(String[] args) {
        System.out.println(Number.values()[Number.One.getNumber() + Number.Two.getNumber()]);
    }
}

public enum Number {
    Zero(0), One(1), Two(2), Three(3);
    private final int someIndexThatLooksLikeACardinalButIsNot;

    private Number(int card) {
        this.someIndexThatLooksLikeACardinalButIsNot = card;
    }

    public int getNumber() {
        return this.someIndexThatLooksLikeACardinalButIsNot;
    }
}