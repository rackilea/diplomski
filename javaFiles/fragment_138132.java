public void run() {        
    try {
        Base.open("myConnectionJNDIName");
        //do some real work here
    } finally {
        Base.close();//always close connection
    }
}