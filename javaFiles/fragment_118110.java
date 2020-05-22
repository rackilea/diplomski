_future = _execService.scheduleWithFixedDelay(new Runnable()
    {
        @Override
        public void run()
        {
            Log.d("Timer", "Run begin");

            Runnable task = new Runnable()
            {
                @Override
                public void run()
                {
                    Log.d("Timer", "Main thread tick");
                    PausableTimer.this.onTick();
                }
            };
            Handler mainHandler = new Handler(Looper.getMainLooper());
            mainHandler.post(task);

            _elapsedTime += PausableTimer.this._interval;
            Log.d("Timer", "Run middle");


            // If time has exceeded duration, stop timer
            if (_duration > 0 && _elapsedTime >= _duration)
            {
                Log.d("Timer", "Finish");
                onFinish();
                _future.cancel(false);
            }
        }
    }, 0, PausableTimer.this._interval, TimeUnit.MILLISECONDS);