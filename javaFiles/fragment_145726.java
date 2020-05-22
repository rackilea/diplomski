public class Main001 {

        public static void main(String[] args) {
            A right = createRightInstance();
            B left = createLeftInstance();

            left.invoke(right);
            System.out.println("Done!!!");
        }

        public static B createLeftInstance() {
            return new B2();
        }

        public static A createRightInstance() {
            return new A2();
        }

    }

    class A{

    }

    class A1 extends A{

    }

    class A2 extends A1{

    }

    class B{
        public void invoke(A x) {
            System.out.println("Invoking method A on B with argument " + x.getClass().getName());
        }
        public void invoke(A1 x) {
            System.out.println("Invoking method A1 on B with argument " + x.getClass().getName());
        }
        public void invoke(A2 x) {
            System.out.println("Invoking method A2 on B with argument " + x.getClass().getName());
        }
    }

    class B1 extends B{
        public void invoke(A x) {
            System.out.println("Invoking method A on B1 with argument " + x.getClass().getName());
        }
        public void invoke(A1 x) {
            System.out.println("Invoking method A1 on B1 with argument " + x.getClass().getName());
        }
        public void invoke(A2 x) {
            System.out.println("Invoking method A2 on B1 with argument " + x.getClass().getName());
        }

    }

    class B2 extends B1{
        public void invoke(A x) {
            System.out.println("Invoking method A on B2 with argument " + x.getClass().getName());
        }
        public void invoke(A1 x) {
            System.out.println("Invoking method A1 on B2 with argument " + x.getClass().getName());
        }
        public void invoke(A2 x) {
            System.out.println("Invoking method A2 on B2 with argument " + x.getClass().getName());
        }
    }