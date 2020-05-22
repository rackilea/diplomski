interface Visitor {
   void visit(A a);

   void visit(B b);
}

class PrinterImpl implements Printer, Visitor {

   void print(A a) {
      System.out.println("a");
   }

   void print(B b) {
      System.out.println("b");
   }

   public <T extends A> void genericPrint(T b) {
      b.accept(this);
   }

   public void visit(A a) {
      print(a);
   }

   public void visit(B b) {
      print(b);
   }
}

interface Printer {
   public <T extends A> void genericPrint(T a);
}

class A {
   public void accept(Visitor v) {
      v.visit(this);
   }
}

class B extends A {
   public void accept(Visitor v) {
      v.visit(this);
   }
}