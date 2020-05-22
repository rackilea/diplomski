myRenderer.startCalc(new Handler(){

    public void handleMessage (Message msg){

        if(msg.what==MyRenderer.CALC_FINISHED){
            // Update UI
            // this code will always be executed in the UI thread

        }

    }

});