class MutableInteger {
    public int value;
}


class C {
   public C(int[] i) {
       ++i[0];
   }
}
class D {
   public D(MutableInteger i) {
       ++i.value;
   }
}
class E {
   public E(AtomicInteger i) {
       i.incrementAndGet();
   }
}
public class Jaba {
    public static void main(String args[]) {

        int[] iii = new int[]{ 0 };
        System.out.println(iii[0]);
        new C(iii);
        System.out.println(iii[0]);
        MutableInteger mi = new MutableInteger();
        System.out.println(mi.value);
        new D(mi);
        System.out.println(mi.value);
        MutableInteger ai = new AtomicInteger(0);
        System.out.println(ai);
        new E(ai);
        System.out.println(ai);
    }
}