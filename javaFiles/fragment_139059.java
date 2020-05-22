public float gokuStartingPositionX;

public PlayScreen(DBZ game){
    .....
    new B2WorldCreator(world,map);

    gokuStartingPositionX=64/DBZ.PPM;  //added in your method
    player = new Goku(world, this);
} 

public void update(float dt){
    handleInput(dt);

    world.step(1/60f, 6, 2);
    player.update(dt);
    //camera position is decided by player position and keep camera in this way so it cover whole viewport width with screen
    gameCam.position.x = player.b2body.getPosition().x + gamePort.getWorldWidth()/2 - gokuStartingPositionX;

    gameCam.update();
    renderer.setView(gameCam);
}