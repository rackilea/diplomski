private static final float GAME_WIDTH = 144;
private static final float GAME_HEIGHT = 160;

public void create(){
    //...
    viewport = new ExtendViewport(GAME_WIDTH, GAME_HEIGHT);
    //...
}

public void resize(int width, int height){
    viewport.update(width, height, false); //centering by putting true here would put (0,0) at bottom left of screen, but then the game rectangle would be off center

    //manually center the center of your game box
    Camera camera = viewport.getCamera();
    camera.position.x = GAME_WIDTH /2;
    camera.position.y = GAME_HEIGHT/2;
    camera.update();
}