public class Dog {

    public Dog(String a, String b, String c) {
        super("Canidae");
        // ...
    }

    public static class Builder {
        private String a;
        private String b;
        private String c;

        public Builder() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public Builder withA(String a) {
            this.a = a;
            return this;
        }

        public Builder withB(String b) {
            this.b = b;
            return this;
        }

        public Builder withC(String c) {
            this.c = c;
            return this;
        }

        public Dog build() {
            if (this.a == null || this.b == null || this.c == null) {
                throw new InvalidStateException();
            }

            return new Dog(this.a, this.b, this.c);
        }
    }
}