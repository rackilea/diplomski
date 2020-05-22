private static volatile RESTSERVICE RESTSERVICEINSTANCE;

public static RESTSERVICE getInstance(){
    RESTSERVICE restservice = RESTSERVICEINSTANCE;
    if(restservice == null){
        synchronized (RESTSERVICE.class){
            restservice = RESTSERVICEINSTANCE;
            if(restservice == null){
                restservice = new RESTSERVICE();
            }
        }
    }
    return restservice;
}