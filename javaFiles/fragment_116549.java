new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            //Here you can send the extras.
            Intent i = new Intent(this, NextActivity.class);
            startActivity(i);

            // close this activity
            finish();
        }
    }, 2000);