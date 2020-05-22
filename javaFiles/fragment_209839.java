private int leftTime;
private boolean isActive;

public int getLeftTime() {
    return leftTime;
}

public void setLeftTime(int leftTime) {
    this.leftTime = leftTime;
}

public void decLeftTime() {
    this.leftTime--;
}

public boolean isActive() {
    return isActive;
}

public void setActive(boolean isActive) {
    this.isActive = isActive;
}