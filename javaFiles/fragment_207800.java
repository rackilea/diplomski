class MyService {

    private String error;

    public void doBackEndThing(){
        try {
            backEndService.doRemoteCall();
        } catch (BackendException e) {
           error ="Backend is currently not available";
        }
    }
}