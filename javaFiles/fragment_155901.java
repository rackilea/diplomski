public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            myHandler.removeCallbacksAndMessages(null);
            y=0;
            progressIndicator.setText("Covered: " + progressX.getProgress() + "/" +
                    progressX.getMax());
            myHandler.postDelayed(new Runnable(){
                @Override
                public void run(){
                    y+=1;
                    progressIndicator.setText("Covered: " + progressX.getProgress() + "/" +
                            progressX.getMax() + " position is still for " + y + " seconds");
                    runnable=this;
                    myHandler.postDelayed(runnable, 1000);

                }
            },1000);