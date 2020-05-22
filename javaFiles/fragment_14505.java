public void updateState(float delta) {
    if(Gdx.input.isButtonPressed(Buttons.LEFT)){

        if(Gdx.input.getX()>player.getX()) {
            player.setX(player.getX()+5);
        }else if (Gdx.input.getX()<player.getX()){
            player.setX(player.getX()-5);
        }
        if(Gdx.graphics.getHeight()-Gdx.input.getY()>player.getY()){
            player.setY(player.getY() + 5);
        }else if(Gdx.graphics.getHeight()-Gdx.input.getY()<player.getY()){
            player.setY(player.getY()-5);
        }
    }
}