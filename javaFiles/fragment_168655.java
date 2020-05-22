private RefreshingThread refreshingThread = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
}

@Override
protected void onStart(){
    super.onStart();
    refreshingThread = new RefreshingThread();
    refreshingThread.start();       
}  

@Override
protected void onStop(){
    super.onStop();
    refreshingThread.shouldStop(); 
}