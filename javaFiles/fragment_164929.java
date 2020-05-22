public void turnRight(int ticks) {
    if (position0) {
        currentNumber = ticks;
        if (currentNumber == secret1) {
            position1 = true;
            position0 = false;
        }
    }
    if (position2 == true) {
        currentNumber = ticks;
        if (currentNumber == secret3) {
            position3 = true;
        } else {
            position3 = false;
        }
    }
}