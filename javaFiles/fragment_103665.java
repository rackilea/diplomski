FrameLayout frame = new FrameLayout(this);

FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.FILL_PARENT,FrameLayout.LayoutParams.FILL_PARENT,Gravity.CENTRAL)
frame.setLayoutParams(params);


 final TextView mTextField = new TextView(this);

 mTextField.setTextColor(Color.RED);
 mTextField.setTextSize(25);
 mTextField.setTypeface(tf);
 final Handler handler = new Handler();
      final Runnable r = new Runnable() {
            public void run() {
               mTextField.setText("Days : " + getTimes()[0] + " Hours : "
                        + getTimes()[1] + " Minutes : " + getTimes()[2]
                        + " Seconds : " + getTimes()[3]);

                handler.postDelayed(this, 1000);

            }
        };

        handler.postDelayed(r, 1000);

frame.addView(mTextField);
setContentView(frame);