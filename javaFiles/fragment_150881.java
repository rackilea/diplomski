public class A {
        public class B extends A {
            public class C extends B {
                public C() {
                    System.out.println("OK");
                }
            }
        }

        public static void main(String[] args) {
           new A().new B().new C();
        }
    }