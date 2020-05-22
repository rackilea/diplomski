public class SuperChk extends Object {
    private void test() {
        System.out.println(toString());
        System.out.println(super.toString()); //4
    }

    @Override
    public String toString() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SuperChk sc1 = new SuperChk();
        sc1.test();
    }
}