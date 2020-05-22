rightButton.setOnClickListener(new OnClickListener(){
    @Override
    public void onClick(View arg0) 
    {
        // Instead of performing a loop here, just call a runnable, do simple press state checking there.
        mHandler.postDelayed(mRunnable, 100);
    }

});