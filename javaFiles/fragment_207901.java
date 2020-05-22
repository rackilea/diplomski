public void resize(int width, int height){
    viewport.update(width, height, false); 

    //align game box's top edge to top of screen
    Camera camera = viewport.getCamera();
    camera.position.x = GAME_WIDTH /2;
    camera.position.y = GAME_HEIGHT - viewport.getWorldHeight()/2;
    camera.update();

    controlsBottomY = GAME_HEIGHT - viewport.getWorldHeight();
}