protected Scene onCreateScene() {
    Scene myScene = new Scene();  // somewhere you create your scene
    float xSeconds = 5.5f; // meaning 5 and a half second
    boolean repeat = true; // true to reset the timer after the time passed and execute again
    TimerHandler myTimer = new TimerHandler(xSeconds, repeat, new ITimerCallback() {
        public void onTimePassed(TimerHandler pTimerHandler) {
            methodWithStuffToDo();
        }
    });
    myScene.registerUpdateHandler(myTimer);   // here you register the timerhandler to your scene

    .... // some other stuff
    return myScene;
}