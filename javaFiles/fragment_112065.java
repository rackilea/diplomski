scene.registerUpdateHandler(new TimerHandler(3, true, new ITimerCallback() {

        @Override
        public void onTimePassed(TimerHandler pTimerHandler) {
            // your code here will be executed every 3 seconds (see 1st argument of TimerHandler)
            ...
            scene.getChild(LAYER_FRONT).attachChild(birdSprites[i]);
        }
    }));