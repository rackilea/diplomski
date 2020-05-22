if (Gdx.input.isTouched()){
    cam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));
    //check if the touch is on the moveright area, for example:
    if(moveRightBounds.contains(touchPoint.x, touchPoint.y)){
        // if its not moving already, set the right targettile here
    }
}