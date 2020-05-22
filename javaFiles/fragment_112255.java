public boolean isSessionTimeout() {
    HttpSession session = ESAPI.httpUtilities().getCurrentRequest().getSession(false);
    if (session == null)
        return true;
    long lastAccessedTime=System.currentTimeMillis();
    if(session.getLastAccessedTime()!=0){
        lastAccessedTime=session.getLastAccessedTime();
    } 
    Date deadline = new Date(lastAccessedTime + IDLE_TIMEOUT_LENGTH);
    Date now = new Date();      
    return now.after(deadline);
}