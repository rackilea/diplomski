if(...) {
    session.invalidate();
    session = httpRequest.getSession(true); 
    ....
} else if(...){
    session.invalidate();
    session = httpRequest.getSession(true); 
    ....
}