void moveRight(Humans[][] array, int x, int y) {
    array[y][x + 1] = array[y][x];
    array[y][x] = null;
}
void moveUp(Humans[][] array, int x, int y) {
    array[y + 1][x] = array[y][x];
    array[y][x] = null;
}