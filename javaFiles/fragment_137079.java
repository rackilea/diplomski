if(i == 0){
            pauseTime =  timeSwap+= timeInMillies;
            timeMap.put(keyQuestion, pauseTime);
            keyQuestion = q1.getText().toString();
            timerStart();
            i = 1;
        }
        else if(i == 1){
            myHandler.removeCallbacks(updateTimerMethod);
            pauseTime =  timeSwap+= timeInMillies;
            timeMap.put(keyQuestion, pauseTime);
            keyQuestion = q1.getText().toString();
            timeSwap = 0L;
            timeSwap += timeMap.get(keyQuestion);
            startTime = SystemClock.uptimeMillis();
            myHandler.postDelayed(updateTimerMethod, 0);
        }