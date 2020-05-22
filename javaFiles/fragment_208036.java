enum Kind {
    GREEN {
        @Override
        public void doSomething() {
            GreenKind.doSomething();
        }
    },
    WHITE {
        @Override
        public void doSomething() {
            WhiteKind.doSomething();
        }
    };

    public abstract void doSomething();
}