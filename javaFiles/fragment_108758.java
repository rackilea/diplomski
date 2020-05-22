public class Main {

    private int value;

    private Main(int value) {
        this.value = value;
    }

    public int getValue() {
        return (this.value);
    }

    public static class MainBuilder {

        boolean valueWasSet;
        int value;

        public MainBuilder() {
            this.valueWasSet = false;
            this.value = -1;
        }

        public void setValue(int value) {
            this.value = value;
            this.valueWasSet = true;
        }

        public Main build() {
            if (!this.valueWasSet) {
                throw new IllegalStateException("value must be set before a Main can be build.");
            }

            return (new Main(this.value));
        }
    }
}