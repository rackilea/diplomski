public class TestAnonymous {

    public static void main(String[] args) {

        SomeInterface obj = new SomeInterface() {

            @Override
            public void SomeMethod() {

                System.out
                        .println("Yaayy!!! Creating an anonymous class which implements SomeInterface ");

            }
        };

        obj.SomeMethod();

    }

}