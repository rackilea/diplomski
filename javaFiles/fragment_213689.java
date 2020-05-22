public TestClass() {
    CustomEvent bla = new CustomEvent("name", null, null); // TODO: parameterise
    mEventOnLoad = new TestEvent("onLoad", this, bla.new Caller() {
        @Override
        public void call(Object parent, Object callback, Object... objects) {
            // some code here
        }
    });
}