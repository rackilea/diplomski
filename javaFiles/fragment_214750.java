private BooleanBinding createAnyPlayingBinding(final List<Animation> transitions) {
    return new BooleanBinding() {
        { 
            for (Animation transition : transitions) {
                this.bind(transition.statusProperty();
            }
        }
        @Override
        protected boolean computeValue() {
            // return true if any of the transitions statuses are equal to RUNNING:
            for (Animation anim : transitions) {
                if (anim.getStatus() == Status.RUNNING) {
                    return true ;
                }
            }
            return false ;
        }
    };

}