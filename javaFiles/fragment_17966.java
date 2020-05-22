Handler h = new Handler();
Runnable r = new Runnable() {
                @Override
                public void run() {
                    Intent callintent = new Intent(getIntent().ACTION_DIAL);
                    callintent.setData(Uri.parse("tel:zuster"));
                    startActivity(callintent);
                }
            }



floatingactionknop.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View arg0, MotionEvent arg1) {
                switch (arg1.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //start timer
                        h.postDelayed(r,2000);
                        return true;
                    case MotionEvent.ACTION_UP:
                        //stop timer
                        h.removeCallbacks(r);
                        return true;
                }
                return false;
            }
        });