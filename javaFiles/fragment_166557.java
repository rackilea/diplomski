public class Test {
    private class InnerPrivateClass {
        private InnerPrivateClass() {}
    }

    public interface MyInteger {
        int getValue();

        void accept(InnerPrivateClass c);
    }

    private class MyIntegerImpl implements MyInteger {
        @Override
        public int getValue() {
            return 0;
        }

        @Override
        public void accept(InnerPrivateClass c) {}
    }
}