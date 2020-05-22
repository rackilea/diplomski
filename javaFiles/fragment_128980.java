mEngine.registerUpdateHandler(new IUpdateHandler() {

    @Override
    public void reset() {}

    @Override
    public void onUpdate(float pSecondsElapsed) {
        if (frames == 1) {
            for (Sprite s : woodSprites) {
                if (bombSprite.collidesWith(s)) {
                    removeFace(s);
                }
            }
    }
});