public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            y=0;
            myHandler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    myHandler.removeCallbacks(runnable);
                    ...
                    y+=1;
                    runnable=this;
                    myHandler.postDelayed(runnable, 1000);
                    }
            },1000);