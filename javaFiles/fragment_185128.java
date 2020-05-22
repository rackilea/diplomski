public static int score(ABCD abcd) {
    return abcd.accept(new Visitor<Integer>() {
        @Override
        public Integer visitA(ABCD a) {
            return 25;
        }
        @Override
        public Integer visitB(ABCD b) {
            return 7;
        }
        @Override
        public Integer visitC(ABCD c) {
            return 2;
        }

        @Override
        public Integer visitD(ABCD d) {
            return 16;
        }
    });
}