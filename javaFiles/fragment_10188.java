public class Ideone {
    static final int value = 3;

    Ideone getIdeone() {
        System.out.println("getIdeone() called");
        return null;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Ideone ideone = new Ideone().new Test();
        System.out.println(ideone.getIdeone().value);
    }

    class Test extends Ideone {
        static final int value = 5;

        @Override
        Test getIdeone() {
            System.out.println("getIdeone() in Test called");
            return null;
        }
    }
}