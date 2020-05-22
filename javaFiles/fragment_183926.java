private static final int MAX_VALUE = 100;
private static final int MIN_VALUE = 0;

public void lowerVolume(int change) {
    volume -= change;
    volume = Math.max(volume, MIN_VALUE);
}

public void raiseVolume(int change) {
    volume += change;
    volume = Math.min(volume, MAX_VALUE);
}