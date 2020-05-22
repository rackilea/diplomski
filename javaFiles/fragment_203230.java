//create thread on UI Thread (associates with Looper)
Handler handler = new Handler();

//then use it in a background thread
handler.post(new Runnable(){
    public void run(){
        //back on UI thread...
    }
}