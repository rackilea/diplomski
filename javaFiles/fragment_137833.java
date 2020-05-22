btnTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (time == 0) {
                    callAsynchronousTask();
                    time = 1;
                } else {
                    stopTimer();
                    time = 0;
                }
            }
        });