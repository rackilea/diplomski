PreProcessInterceptor.preProcess(..){
    ... 
    retrieve User from token
    check roles
    ...
    //add the user to the context data
    ResteasyProviderFactory.pushContext(User.class, user);

}