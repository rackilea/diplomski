void setShouldCharacterMove(boolean shouldMove) {
    shouldCharacterMove = shouldMove;
    IV_player.removeCallbacks(characterMoveRunnable);
    if (shouldMove) {
        IV_player.post(characterMoveRunnable);
    }
}