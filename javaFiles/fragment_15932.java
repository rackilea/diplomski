public void toggleButtonConnectToClientsFunction(View view) {
    Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //Multithread here
                multicastthreadRun.run();
                for(int counter=0;counter<multicastthreadRun.ClientIpArrayList.size();counter++) {

                    // use proper context
                    TextView textView=new TextView(YourActivityNamethis);//i am obtaining error here

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // Update UI
                        linearLayoutSecondaryTexts.addView(textView);
                    }
                });
                }//end of the for loop
            }
        });t.start();

}