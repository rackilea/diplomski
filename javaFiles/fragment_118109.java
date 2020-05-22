Log.d("Timer", "Starting execution");
    _future = _execService.scheduleWithFixedDelay(new Runnable()
    {
        @Override
        public void run()
        {
            Log.d("Timer", "Run begin"); // fires 

            onTick(); // when I remove this, all below logs fire!

            _elapsedTime += PausableTimer.this._interval;
            Log.d("Timer", "Run middle"); // didn't fire
            Log.d("Timer", "Elapsed time " + _elapsedTime); // didn't fire
            Log.d("Timer", "Duration " + _duration); // didn't fire

            // If time has exceeded duration, stop timer
            if (_duration > 0 && _elapsedTime >= _duration)
            {
                Log.d("Timer", "Finish"); // didn't fire
                onFinish();
                _future.cancel(false);
            }

            Log.d("Timer", "Run End"); // didn't fire
        }
    }, 0, PausableTimer.this._interval, TimeUnit.MILLISECONDS);