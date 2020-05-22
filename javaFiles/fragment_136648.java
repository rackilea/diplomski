private final Runnable characterMoveRunnable = new Runnable() {
    @Override
    public void run() {
        float y = IV_player.getTranslationY();
        IV_player.setTranslationY(y + 5); // Doesn't have to be 5.

        if (shouldCharacterMove) {
            IV_player.postDelayed(this, 16); // 60fps
        }
    }
};