public int getAttackFor(Player player) {
    if (player == player1) {
        return player.getAttack() + 1;
    }
    if ((player == player2) || (player == player3)) {
        return player.getAttack();
    }
    // throw an exception if the player isn't found?
}