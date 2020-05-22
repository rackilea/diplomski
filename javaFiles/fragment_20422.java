private MyGestureListener myGestureListener;

public PlayScreen(Game game) {
    this.game = game;
    myGestureListener = new MyGestureListener();
    Gdx.input.setInputProcessor(new GestureDetector(myGestureListener));
}