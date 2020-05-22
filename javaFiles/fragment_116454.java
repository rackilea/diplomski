enum Action {
    SPEED {
        public void doSomething() {
            // code
        }
    },
    TIME {
        public void doSomething() {
            // code
        }
    };

    public abstract void doSomething();
}


public void analyzeWithAnalytics(Action data) {
    for (int i = 0; i < VALUE; i++) {
        data.doSomething();
    }
}