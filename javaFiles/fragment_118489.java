@Override
public void configure(StateMachineConfigurationConfigurer<States, Events> config)
        throws Exception {
    config
        .withVerifier()
            .enabled(true)
            .verifier(cusomVerifier());
}

@Bean    
public StateMachineModelVerifier customVerifier() {
  return new CustomVerifier();
}

class CustomVerifier extends DefaultStateMachineModelVerifier {
  @Override
  public void verify(StateMachineModel model) {
    super.verify(model); // call the existing sanity check model verifier
    Collection<StateData<State, Event> statesData = model.getStatesData().getStateData(); 
    //log your stuff
  }
}