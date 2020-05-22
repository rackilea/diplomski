protected boolean isSurroundedBy(int player, int x, int y) {
    return isOccupiedByPlayer(player, x - 1, y - 1)
            && isOccupiedByPlayer(player, x, y - 1)
            && isOccupiedByPlayer(player, x + 1, y - 1)
            && isOccupiedByPlayer(player, x - 1, y)
            && isOccupiedByPlayer(player, x + 1, y)
            && isOccupiedByPlayer(player, x - 1, y + 1)
            && isOccupiedByPlayer(player, x, y + 1)
            && isOccupiedByPlayer(player, x + 1, y + 1);
}