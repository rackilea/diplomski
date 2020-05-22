String ret = RandomHelper.withCastTest(new Randomable<String>(s) {

        @Override
        public String get() {
            return s;
        }
    });

    String ret2 = RandomHelper.withoutCastTest(new Randomable<String>(s) {
        @Override
        public String get() {
            return s;
        }
    }, "test2");