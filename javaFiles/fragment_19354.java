public void onTick(long millisUntilFinished) {
        Log.i( "Current Ride", "Timer countdown: " + millisUntilFinished / 1000 +
                " seconds." );
        if (vehicleStopped)
        {
            // Vehicle should have stopped, but it has started moving again
            if (nCurrentSpeed > 0)
            {
                timer.cancel();
                timerStarted = false;
            }
        }
        else if (nCurrentSpeed == 0)
        {
            // If vehicle has just slowed down,
            // once speed drops to zero we have stopped
            vehicleStopped = true;
        }
    }