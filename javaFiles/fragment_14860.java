//Initialise both vectors to vectors that can't be touched (negative)
Vector2 topTouchPos = new Vector2(-1,-1), bottomTouchPos = new Vector2(-1,-1);

//Two people can have up to 20 fingers (most touchscreen devices will have a lower limit anyway)
for (int i = 0; i < 20; i++) {
    //Check if this finger ID is touched
    if (Gdx.input.isTouched(i)) {
        //Classify it as either the top or bottom player
        bool bottom = Gdx.input.getY(i) > Gdx.graphics.getHeight()/2;
        if (bottom) bottomTouchPos.set(Gdx.input.getX(i), Gdx.input.getY(i));
        else topTouchPos.set(Gdx.input.getX(i), Gdx.input.getY(i));
    }
}