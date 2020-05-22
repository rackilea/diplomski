AbstractListener listener = new AbstractListener() {

        @Override
        public void eventEnd() {
            // your implementation
        }

        @Override
        public boolean callMyExtraMethod() {
            //System.out.println("I am callMyExtraMethod");
            return true;
        }
    };

    listener.templateMethod();