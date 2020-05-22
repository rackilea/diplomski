if (nCurrentSpeed <= 5 && !timerStarted) {
        // Flag to indicate if vehicle has come to a complete stop
        vehicleStopped = (nCurrentSpeed == 0);
        // Indicate the timer is running
        timerStarted = true;
        timer.start();
    }