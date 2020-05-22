public enum Fruit {
    APPLE("Apple") {
        private final AppleHelper helper = new AppleHelper();

        @Override
        public <T> List<T> applyFruitFunction(String someString) {
            return helper.doAppleThing(someString);
        }
    },

    ORANGE("Orange") {
        private final OrangeHelper helper = new OrangeHelper();

        @Override
        public <T> List<T> applyFruitFunction(String someString) {
            return helper.doOrangeThing(someString);
        }
    };

    private String name;

    Fruit(String name) {
      this.name = name;
    }

    public String getName() {
      return name;
    }

    public abstract <T> List<T> applyFruitFunction(String someString);
}