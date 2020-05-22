@Override
public void configure(StateMachineConfigurationConfigurer<States, Events> config) throws Exception {
  config.withConfiguration().listener(stateChangeListener());
}

private StateMachineListenerAdapter stateChangeListener() {
   return new StateMachineListenerAdapter<States, Events> () {

        //Override what's necessary, but particularly
        @Override
        public void stateChanged(State<S,E> from, State<S,E> to) {
            //logging
        }
   }
}