class Test
{
    public static void main (String[] args) throws java.lang.Exception
    {   
        B b = new B();
        b.print();
    }

    public static class A {
        protected int member = 1;
        public void print(){
            System.out.println("A: "+member);
        }
    }

    public static class B extends A {
        protected int member = 2;
        public void print(){
            super.print();
            System.out.println("B: "+member);
            System.out.println("C: "+super.member);
        }
    }
}