interface StringFunc {
   String func(String s);
}

void doSomething(StringFunc funk) {
   System.out.println(funk.func("whatever"));
}

doSomething(new StringFunc() {
      public String func(String s) {
           return s + "asd";
      }
   });


doSomething(new StringFunc() {
      public String func(String s) {
           return new StringBuffer(s).reverse().toString();
      }
   });