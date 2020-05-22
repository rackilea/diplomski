@Override
protected void doUnexpectedFailure(Throwable e) {
    if(e instanceof InvalidPolicyException) { 
        sendError(); //send message to reload client (wrong client version)
        return; //that's it
    }
    super.doUnexpectedFailure(e);
}