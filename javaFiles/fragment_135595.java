boolean moveon;
//...
onCreate() {
    moveon = false;
//...

// Still in UI thread here
Handler myh = new Handler();
final Resources res = getResources(); // final so we can access it inside second thread
new Thread(new Runnable() { 
    public void run() {
        // In second thread
        for(int i=0; i<3; i++){
            // Now we use the Handler to post back to the UI thread from the second thread
            myh.post(new Runnable() { 
                public void run() {
                   // In UI thread, update here and then invalidate
                   id = res.getIdentifier("txt"+Integer.toString(winners[i]), "id",
                    getApplicationContext().getPackageName());      
                   TextView temp = (TextView)findViewById(id);
                   temp.setBackgroundColor(Color.parseColor("#ffd700"));
                   temp.getBackground().setAlpha(127);
                   temp.postInvalidate();
                }
            });

            Thread.sleep(delayMs); // Sleep second thread
        }
        myh.post(new Runnable() { 
                public void run() {
                   // In UI thread, reset the moveon to true on correct thread
                   moveon = true;
                }
            });
    }
}).start();