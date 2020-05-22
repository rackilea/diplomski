public enum DogValidationType implements ValidationStrategy<Dog> {
    STRATEGY_1 {
        public List<Rule<? super Dog>> getRules() {
            // answer rules...
        }
    },
    // more dog validation strategies
}