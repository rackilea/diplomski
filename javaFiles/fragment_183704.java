if(Gdx.input.justTouched()){
    Vector2 touch = viewport.unproject(new Vector2(Gdx.input.getX(), Gdx.input.getY()));

    //Check if button if touched
    if(buttonBounds.contains(touch)){
        System.out.println("Button touched!");
        //Do something
    }
}