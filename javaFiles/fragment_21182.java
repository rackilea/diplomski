@Override
public void handleInput() {

    if (Gdx.input.isTouched()) {
        if (playSprite.getBoundingRectangle().contains(Gdx.input.getX(), Gdx.input.getY())) {
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }
}