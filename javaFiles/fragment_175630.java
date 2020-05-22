protected void increase() {
    if (currentPosition == listCount) {
        currentPosition = minValue;
    } else {
        currentPosition++;
    }
}

protected void decrease() {
    if (currentPosition == minValue) {
        currentPosition = listCount;
    } else {
        currentPosition--;
    }
}