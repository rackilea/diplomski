Handler textNextHandler = new Handler(); 

    final Runnable textTimer = new Runnable() 
    {
        public void run() 
        {
           // ROTATE YOUR TEXT HERE THEN TELL IT HOW LONG TO DELAY UNTIL NEXT
           textNextHandler.postDelayed(this, 500);  
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        textNextHandler.postDelayed(textTimer,500); 
    }       

    @Override
    public void onPause() {
        super.onPause();
        textNextHandler.removeCallbacks(textTimer);
    }