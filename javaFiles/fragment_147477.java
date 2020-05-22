button.addListener(new ClickListener() {
    @Override
    public void clicked(InputEvent event, float x, float y) {
        button.setText("Clicked!");
    }
});
Gdx.input.setInputProcessor(stage);