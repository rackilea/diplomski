// Fill your array here

new Handler().postDelayed(new Runnable() {
    @Override
    public void run() {
        // work to be done after 6000 msec
        Toast.makeText(MainActivity.this, "6 sec passed", Toast.LENGTH_SHORT).show();
    }
},6000); // time in msec