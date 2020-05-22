class MyProcess {

    final Completion myCompletion = new Completion() {
        @Override
        public void success() {}
        @Override
        public void fail(String err) {}
    }

    void methodA(Completion c) {}

    void methodB() {
        methodA(myCompletion);
    }
}