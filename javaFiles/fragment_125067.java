Lib l = new Lib() {
        @Override
        void xxx() {
            Assert.fail("calling xxx() is not allowed");
        }
    };