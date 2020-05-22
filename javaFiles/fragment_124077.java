if(Gdx.input.isKeyPressed(Input.Keys.UP) {
    if(player.getDirection() == Direction.UP) {
        if(timeout < 0) {
            // move player
        }
    } else {
        player.setDirection(Direction.UP);
        //Set some timeout in seconds
        timeout = 0.5;
    }
}

//Considering that this method is being called in your update method then reduce the timeout.
timeout -= Gdx.graphics.getDeltaTime();