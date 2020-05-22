try{

}catch(PrivilegedActionException e){
    Throwable tmp = e;
    while(tmp != null){
        if(tmp instanceof SocketTimeoutException){
            SocketTimeoutException cause = (SocketTimeoutException) tmp;
            //Do what you need to do here.
            break;
        }
        tmp = tmp.getCause();
    }
}