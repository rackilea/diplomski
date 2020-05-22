Vector3 touchCoords = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0); // use a Vector2 if you switch from Camera to Viewport
    camera.unproject(touchCoords); // converts screen coordinates to game coordinates
    if(touchCoords.x > [button left side x] &&
       touchCoords.x < [button right side x] &&
       touchCoords.y > [button bottom y] &&
       touchCoords.y < [button top y])
        // do something here
    else if(... check coordinates for the other button)
         // then do this
    // and so on for additional buttons