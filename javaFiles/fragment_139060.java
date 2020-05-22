public Goku(World world, PlayScreen screen){
    super(screen.getAtlas().findRegion("goku_sprite"));
    this.world = world;
    defineGoku(screen.gokuStartingPositionX);

    gokuStand = new TextureRegion(getTexture(), 5,12,59,85);
    setBounds(0,0,59/DBZ.PPM,85/DBZ.PPM);
    setRegion(gokuStand);

}

public void defineGoku(float startX){
    BodyDef bdef = new BodyDef();
    bdef.position.set(startX,32/DBZ.PPM);
    bdef.type = BodyDef.BodyType.DynamicBody;
    b2body = world.createBody(bdef);
    ... 
}