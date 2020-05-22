// Only including one key, process is same for others.
if (rightKey) {
    isMoving = true;
    if (aligned)
        dir = 0;
} /* chain other keys in here */ else {
    isMoving = false;
}

if (isMoving) {
    if (!aligned) {
        move(dir);
        render(dir);
    } else {
    }
}