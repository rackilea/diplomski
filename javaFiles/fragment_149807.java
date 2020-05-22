public void loopButton() {
    for(int i = 0; i < 1000; i++) {
        for(Target t : targets) {
            findButton(t);
        }
        sleep();
    }
}