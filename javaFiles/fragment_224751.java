pauseButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                mTime += mCurrentLapse;
                mHandler.removeCallbacks(mUpdateTimeTask);
            }
        });