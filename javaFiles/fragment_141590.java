class A {}

class B {
     public static void main(String[] args) throws Exception {
         A a1 = new A();
         class A {}
         A a2 = new A();
         Class<?> clazz = Class.forName("A");
         Object a3 = clazz.getDeclaredConstructor().newInstance();

         System.out.println(a1); // A@___
         System.out.println(a2); // B$1A@____  
         System.out.println(a3); // A@___
     }
}