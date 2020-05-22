enum State {
    YELLOW(){
        @Override
        public State next() {
            return RED;
        }
    },
    RED(){
        @Override
        public State next() {
            return GREEN;
        }
    },
    GREEN(){
        @Override
        public State next() {
            return YELLOW;
        }
    };
    public abstract State next();
}