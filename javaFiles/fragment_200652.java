// Obtain our environment naming context
Context initCtx = new InitialContext();
Context envCtx = (Context) initCtx.lookup("java:comp/env");

// Look up our DAO
ActorDao ad = (ActorDao)envCtx.lookup("dao/actor");