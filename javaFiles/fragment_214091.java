public static getSharedServer(){
    if(sharedServer == null) {
         sharedServer = ... //create server instance
    }
    return sharedServer;
}