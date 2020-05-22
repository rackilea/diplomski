startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                mStartTime = SystemClock.uptimeMillis();
                mHandler.postDelayed(mUpdateTimeTask, 0);
            }
        });