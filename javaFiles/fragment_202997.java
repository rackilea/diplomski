public void someMethod(){
    InitialContext context = createInitialContext();
    context.lookup(....);
}

protected InitialContext createInitialContext(){
    return new InitialContext(); // can be overridden by a subclass 
                                 // and therefore by tests as well to
                                 // return a mock
}