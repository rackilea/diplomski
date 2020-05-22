if (b.getY() < 0) {
    // note that variables should start with lower-case letters
    vy = Math.abs(vy); // make sure that it is going in a positive direction
}

if (b.getY() > sizeY - b.getRadius()) {
    vy = -Math.abs(vy);
}