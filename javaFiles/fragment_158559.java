public static void main(String [] args){
    // initialize the SDK and report only once per process
    try{
        ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
        config.setServerAddress(new URI("ws://myServerAddress:5095"));
        SDK.init(config);
        Reporter.init();

        //put your test code here.

        //Generate the report and cleanup the SDK usage.
        Reporter.generateReport();
        SDK.cleanup();
    }  catch(Exception e){
    }
}