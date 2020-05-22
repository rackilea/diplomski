final TextView textview=findViewById(R.id.tv);
    new Timer().scheduleAtFixedRate(new TimerTask() {
        int value=0; //start at 0
        @Override
        public void run() {
            value++ ; 
            runOnUiThread(new Runnable() { //only the main thread can touch his views
                @Override
                public void run() {
                    textview.setText("This page was refreshed " + value + " seconds ago"); //refresh text

                }
            });
        }
    }, 0, 1000); //reschedule every 1000 milliseconds


}