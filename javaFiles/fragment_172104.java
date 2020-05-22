public class Foo
{
    static class Super{
        private int a;
        public int getA() { return a; }
    }

    static class Sub extends Super{
        private int a = 10;
        @Override
        public int getA() { return a; }
    }

    public static void main(String args[]) {
        Super sup1 = new Super();
        Super sup2 = new Sub();
        Sub   sub  = new Sub();
        System.out.println(sup1.getA());
        System.out.println(sup2.getA());
        System.out.println(sub.getA());
    } 
}