public class LoginPrepThread extends SwingWorker<String,String> {

    private final UIMain parent;

    public LoginPrepThread(UIMain w){
        parent = w;
    }

    @Override
    protected String doInBackground() throws Exception {
        try{
            publish("Fetching preferences...");
            Thread.sleep(1000);
            publish("Updating permissions...");
            Thread.sleep(1000);
            publish("Scanning workbench...");
            Thread.sleep(1000);
            publish("Finalizing...");
            Thread.sleep(2000);
            publish("Finished...Please wait");
            Thread.sleep(1000);
            parent.getLayout().show(parent.getMainFrame().getContentPane(), "view.main");
        }catch(Exception e){

        }
        return null;
    }

    protected void process(List<String> item) {
        parent.getLoadingLable().setText(item.get(0));
    }

}