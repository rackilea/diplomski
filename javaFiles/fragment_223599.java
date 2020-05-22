doNormalStartupStuff();
try{
    connectToDb();
}
catch(UnableToConnectToDbException e){
    log.fatal("Unable to connect to database, shutting down");
    //possibly send alerts out
    shutdown();
}