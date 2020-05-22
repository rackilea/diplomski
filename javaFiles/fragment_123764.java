public void commonStarter(boolean isElk) {
    Animal animal = None;
    if(isElk) {
        animal = new Elk();
    } else {
        animal = new Fox();
    }
    ... // Do your logic.
}