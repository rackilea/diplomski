public class Test {
    public static void main(String[] args) {
        new Object() {
            public void test() {
                System.out.println(this.getClass().getDeclaringClass()); //null
                System.out.println(this.getClass().getEnclosingClass()); //not null
            }
        }.test();
    }
}