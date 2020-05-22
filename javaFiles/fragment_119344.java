float counter = 0f;
@Override
public void render() {
    if (counter < 3) {
        counter += Gdx.graphics.getDeltaTime();
        countUpLabel.setText(String.format("Time:\n%01.22f", counter));
    }
    // call glClear, stage.act, stage.draw, etc.
}