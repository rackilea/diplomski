// x, y - character coordinates
// r - character circle radius
// speedX, speedY - character speed
// intersectionX, intersectionY - intersection coordinates
// left, right, bottom, top - wall rect positions

// I strongly recomment using a const "EPSILON" value
// set it to something like 1e-5 or 1e-4
// floats can be tricky and you could find yourself on the inside of the wall
// or something similar if you don't use it :)

if (isLeftCollision) {
    x = intersectionX - EPSILON;
    if (speedX > 0) {
        speedX = 0;
    }
} else if (isRightCollision) {
    x = intersectionX + EPSILON;
    if (speedX < 0) {
        speedX = 0;
    }
}

if (isBottomCollision) {
    y = intersectionY - EPSILON;
    if (speedY > 0) {
        speedY = 0;
    }
} else if (isTopCollision) {
    y = intersectionY + EPSILON;
    if (speedY < 0) {
        speedY = 0;
    }
}