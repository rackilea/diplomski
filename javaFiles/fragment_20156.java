public void update() {

playerRect.setPosition(player.getxPos(), player.getyPos());
platformRect.setPosition(getxPos(), getyPos());



// Make Player stop moving if the two rectangles collide

isOverlapping = playerRect.overlaps(platformRect);

if (isOverlapping) {
        player.setxSpeed(0);
}
}