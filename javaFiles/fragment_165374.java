// The Action must implement the SessionAware interface

private Map<String,Object> session; // with Setter
private final static String BUSY = "I'm busy. Try again";

public String execute(){
    if (session.get(BUSY)!=null){
       LOG.debug("Another download is in progress. I stop here");
       return NONE;
    }
    try {
        session.put(BUSY,BUSY);
        /* file loading and stuff ... */
    } finally {
        session.remove(BUSY);
        return SUCCESS;
    }
}