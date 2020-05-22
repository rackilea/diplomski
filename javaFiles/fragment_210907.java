//Set visible progres bar
findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);

        //Timer in your case 30 sek
        int timer = 30*1000;

        //create handler
        final Handler handler = new Handler();

        //set handler delayed                
        handler.postDelayed(new Runnable() {
            @Override
            public void run() { 

        //Hidden progress bar
        findViewById(R.id.progress_bar).setVisibility(View.INVISIBLE);

        //your toast
        Toast.makeText(this,"your msg",Toast.LENGTH_LONG).show();

        //start new activity
        startActivity(your intent)
          }
        }, timer);
    }