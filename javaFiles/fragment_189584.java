public class Config {

    private static HashMap<String,String> map;

    private final Runnable callback;

    public Config(Runnable callback){
        this.run = run;
        final ServerProxyAsync serverProxy= GWT.create(ServerProxy.class);
        serverProxy.getParameters(new AsyncCallback<HashMap<String,String>>() {
            @Override
            public void onFailure(Throwable caught) {
                System.out.println("getParameters: FAILED!");
                map=null;
            }

            @Override
            public void onSuccess(HashMap<String, String> result) {
                System.out.println("getParameters: OK!");
                map=result; 
                callback.run();
            }
        });
    }
}