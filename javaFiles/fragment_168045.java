Runnable r = new Runnable(){

    @Override
    public void run(){
        //TODO: define abort criteria for boolean:isRunning
        while(isRunning){
            //TODO define int:pollDelay
            Thread.sleep(pollDelay);

            //here you poll for new results
            trans.setRequest(req);
            ReadMultipleRegistersResponse res = 
                (ReadMultipleRegistersResponse) trans.getResponse();
            tf1.setText(String.valueOf(res.getRegisterValue(0)));
            ...
        }
    }
}