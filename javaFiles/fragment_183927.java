public void lowerVolume() {
    volume--;
    volume = Math.max(volume, MIN_VALUE);
}

public void raiseVolume() {
    volume++;
    volume = Math.min(volume, MAX_VALUE);
}