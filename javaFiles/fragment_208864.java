private final IntSet downKeys = new IntSet(20);

private InputAdapter inputAdapter = new InputAdapter(){
    public boolean keyDown (int keycode) {
        downKeys.add(keycode);
        if (downKeys.size >= 2){
            onMultipleKeysDown(keycode);
        }
        return true;
    }

    public boolean keyUp (int keycode) {
        downKeys.remove(keycode);
        return true;
    }
};

private void onMultipleKeysDown (int mostRecentKeycode){
    //Keys that are currently down are in the IntSet. Do whatever you like, for example:

    //Alt-F4 to quit:
    if (downKeys.contains(Input.Keys.ALT_LEFT) || downKeys.contains(Input.Keys.ALT_RIGHT)){
        if (downKeys.size == 2 && mostRecentKeycode == Input.Keys.F4){
            Gdx.app.exit();
        }
    }
}

@Override
public void show() {
    downKeys.clear();
    Gdx.input.setInputProcessor(inputAdapter);
}