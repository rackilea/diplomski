if(!canFall){
        velocity.y = 0;
    }else
        velocity.y += MainScreen.GRAVITY.y;

    if(Gdx.input.isKeyPressed(Keys.A)){
        velocity.x -= 10 * Gdx.graphics.getDeltaTime();
    }
    else if(Gdx.input.isKeyPressed(Keys.D)){
        velocity.x += 10 * Gdx.graphics.getDeltaTime();
    }else
        velocity.x = 0;