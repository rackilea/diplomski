public class Test {

    public static void main(String[] args) {
        final int x = 10;

        class Local {
            int addToX(int value) {
                return x + value;
            }
        }

        Local local = new Local();

        int result1 = local.addToX(1);
        int result2 = local.addToX(2);
        System.out.println(result1);
        System.out.println(result2);
    }
}