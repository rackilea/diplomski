new TestFace() {
        public String outie() {
            String val = "something";
            return val;
        }
        public String toString() {
            return outie();
        }
    }