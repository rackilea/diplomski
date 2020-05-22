private class InnerChild {
}

private class InnerChildA extends InnerChild {
}

private class InnerChildB extends InnerChild {
}

private class InnerChildC extends InnerChild {
}

enum InnerChildEnum {

    CHILD_A {
        @Override
        public InnerChild getInstance() {
            return sampleParent.new InnerChildA();
        }
    },
    CHILD_B {
        @Override
        public InnerChild getInstance() {

            return sampleParent.new InnerChildB(); // compile error
        }
    },
    CHILD_C {
        @Override
        public InnerChild getInstance() {
            return sampleParent.new InnerChildC();
        }
    };

    private static SampleParent sampleParent = new SampleParent();

    public abstract InnerChild getInstance();
}