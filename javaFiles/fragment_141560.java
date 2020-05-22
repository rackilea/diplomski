Thread letters = new Thread() {
        public void run() {
            say("a");
            say("b");
            say("c");
        }
    };

    Thread numbers = new Thread() {
        public void run() {
            say("1");
            say("2");
            say("3");
        }
    };