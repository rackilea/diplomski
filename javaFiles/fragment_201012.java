public boolean noneLeft() {
    for (Bubble b : bubbles) {
        if (!b.isPopped()) {
            return false;
        }
    }
    return true;
}