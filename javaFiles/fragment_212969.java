class AwesomeGameClass {
    public void init() {
        Gdx.input.setInputProcessor(new InputProcessor() {
            @Override
            public boolean TouchDown(int x, int y, int pointer, int button) {
                if (button == Input.Buttons.LEFT) {
                    onMouseDown();
                    return true;
                }
                return false
            }

            ... the other implementations for InputProcessor go here, if you're using Eclipse or Intellij they'll add them in automatically ...
        });
    }

    private void onMouseDown() {
    }
}