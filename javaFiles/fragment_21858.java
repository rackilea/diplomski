for (int k = i; k > 0; k++) {
    for (int j = 0; j < width; j++) {
        world[k][j] = world[k - 1][j];
    }
}
// Adding a new blank row on the top of the world
for (int j = 0; j < width; j++) {
    world[0][j] = false;
}