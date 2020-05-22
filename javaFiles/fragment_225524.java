private static final int SUCCESS = 0;
private static final int FAIL = 1;

//This is the handler
Handler uiHandler = new Handler(){
    @Override
    public void handleMessage(Message msg){
        //Here is how you use switch statement
        switch(msg.what){
        case SUCCESS:
            //Do something      
            break;
        case FAIL:
            //Do something
            break;
        }

    }
};

//Here is an example how you might call it
Thread t = new Thread() {
    @Override
    public void run(){
        doSomeWork();
        if(succeed){
            /*we can't update the UI from here so we'll signal our handler 
             and it will do it for us.*/
            // 'sendEmptyMessage(what)' sends a Message containing only the 'what' value.
            uiHandler.sendEmptyMessage(SUCCESS);
        }else{
            uiHandler.sendEmptyMessage(FAIL);
        }
    }   
}