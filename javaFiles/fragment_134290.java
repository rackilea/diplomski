final Button mClose = (Button) findViewById(R.id.force_close);
mClose.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v) {           
        System.exit(0);
        //or you can use 
        //android.os.Process.killProcess( android.os.Process.myPid());
    }
});