class A {
   public static void main(String[] args) {
       Object o = new Object() {
           public int x = 0;
           {
               System.out.println("x: " + x++);
               System.out.println("x: " + x++);
           }
       };
       //System.out.println(((A$1)o).x);
   }
}