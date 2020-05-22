btnStart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
startService(v);
            timer.start();
        }
    });

    btnStop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
stopService(v);
            timer.cancel();
        }
    });
    }