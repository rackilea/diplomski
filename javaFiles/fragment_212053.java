public class Outer{

    private static interface Inner {

        static class InnerImpl implements Inner {

            private String a;

            @Override
            public void setA(String a) {
                this.a = a;
            }
        }

        void setA(String a);

    }

    // either instantiate directly or again wrap it in a `createInner()` method 
    // Inner inner = new Inner.InnerImpl();
}