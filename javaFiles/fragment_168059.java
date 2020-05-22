public static void main(String[] args)
{
     BigClass big = new BigClass();

     A a = big.new A();
     big.a = a;

     B b = big.new B();
     b.a1 = a;
     big.b = b;

     C c = big.new C();
     c.b1 = b;
     big.c[0] = c;

     c1 c1 = big.new c1();
     big.c[0] = c1;

     c2 c2 = big.new c2();
     big.c[1] = c2;

     c3 c3 = big.new c3();
     big.c[2] = c3;
}