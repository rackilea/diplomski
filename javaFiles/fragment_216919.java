public boolean login() throws LoginException{
  // ...
  String username = null;
  String password = null;
  // check if useSharedState is true, if it is true, use the 
  // username/password from shared state.
  if ("true".equalsIgnoreCase(option_.get("useShardState"))) {
    username = (String)sharedStateMap_.get("javax.security.auth.login.name");
    password = (String)sharedStateMap_.get("javax.security.auth.login.password");
  } else {
    // get the username and password from the CallbackHandler
    Callback [] callbacks = {new NamePasswordCallback()};
    handler_.handle(callbacks);
    username = callback.getUserId();                
    password = callback.getPassword();
    //save the username and password into the shared state
    sharedStateMap.put("javax.security.auth.login.name",username);
    sharedStateMap.put("javax.security.auth.login.password",password);
  }
  // ... communicates with data store to authenticate this user     
}