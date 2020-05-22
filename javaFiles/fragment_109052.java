if(Gdx.input.justTouched()){
        Vector3 touch = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touch);
        for (Lama lama : lamas) {
            if(lama.lamarect.contains(touch.x, touch.y)){
                money+=100;
            }else{
                Gdx.app.setLogLevel(Application.LOG_DEBUG);
                Gdx.app.debug("POSITION", "X touched: " + touch.x + " Y touched: " + touch.y);
            }
        }
    }