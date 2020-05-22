public class ReallyComplicatedClass {
    private int int1;
    private int int2;
    private String str1;
    private String str2;
    // ... and so on
    // Note that the constructor is private
    private ReallyComplicatedClass(Builder builder) {
        // set all those variables from the builder
    }
    public static class Builder {
        private int int1;
        private int int2;
        private String str1;
        private String str2;
        // and so on 
        public Builder(/* required parameters here */) {
            // set required parameters
        }
        public Builder int1(int newInt) {
            int1 = newInt;
            return this;
        }
        // ... setters for all optional parameters, all returning 'this'
        public ReallyComplicatedClass build() {
            return new ReallyComplicatedClass(this);
        }
    }
}