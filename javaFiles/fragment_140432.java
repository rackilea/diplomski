public enum State {

    STATE_A {
        @Override
        public void doStateDependentLogic(final State newState) {
            switch (newState) {
                case STATE_B:
                    //do stuff
                //case SOME_OTHER_STATE
            }
        }
    },
    STATE_B {
        @Override
        public void doStateDependentLogic(final State newState) {
        }
    };

    public abstract void doStateDependentLogic(State newState);
}