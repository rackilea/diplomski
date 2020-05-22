class FirstTimeCaller {
    private boolean isFirstTime = true;
    void methodWithState() {
        if (isFirstTime) {
            ... // Do first-time thing
            isFirstTime = false;
        } else {
            ... // Do the other thing
        }
    }
}