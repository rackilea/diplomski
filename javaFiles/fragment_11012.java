class B extends A {
     int var2;

     public static B createB(int x, int y) {
         x = f(y);
         return new B(x, y);
     }

     public B(x, y) {
         super(x);
         this.var2 = y;
     }
 }