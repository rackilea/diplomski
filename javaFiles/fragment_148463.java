public class ShoeFactory {

    public static class Shoe {
        private String name;

        private Shoe() {
        }

        private Shoe(String name) {
            this.name = name;
        }
    }

    public static Shoe createShoe(String shoeName) {
        return new Shoe(shoeName);
    }
}