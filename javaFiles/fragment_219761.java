interface Silly {
   public void narf();
   public void poit(Silly s);
}

public class Bird implements Silly {
public static void main(String args[]) {
     System.out.println("zero");   // 1. zero
     Silly s = new SillyBird(1);   // 2. zanzibar
     Silly s2 = new Loony();       // 3. zanzibar zircon duchess stupendous
     s.poit(s2);                   // 4. snark
     s2.poit(s);                   // 5. drum zort
     System.out.println("zymurgy");// 6. zymurgy
   }
   public Bird() {
     this(0);
     System.out.println("zircon");
   }
   public Bird(int i) {
     System.out.println("zanzibar");
   }
   public void narf() {
     System.out.println("zort");
   }
   public void poit(Silly s) {
      s.narf();
   }
}

class SillyBird extends Bird {
   public SillyBird() {
     System.out.println("duchess");
   }
   public SillyBird(int i) {
      super(i);
   }
   public void narf() {
      System.out.println("drum");
      super.narf();
   }
}

class Loony extends SillyBird {
   public Loony() {
      System.out.println("stupendous");
   }
   public void narf() {
     System.out.println("snark");
   }
}