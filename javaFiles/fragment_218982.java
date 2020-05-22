public class Outer {

        private class Inner {
        }

        public static void main(String[] args) {
            Test t = new Test();
            Inner i = t.new Inner();
            System.out.println(i instanceof Test);  //inconvertible types => normal
            System.out.println(t instanceof Inner); // inconvertible types => normal
        }

    }