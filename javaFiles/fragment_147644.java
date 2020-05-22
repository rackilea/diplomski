private void createBridge(Vector2 vecFrom, Vector2 vecTo, Float thickness){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;
        bodyDef.position.set(vecFrom);

        Body tmpBody = Box2dGameWorld.getInstance().getWorldBox2D().createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.set( new Vector2[]{
                new Vector2(0,0)
                ,new Vector2(vecTo.x-vecFrom.x,vecTo.y-vecFrom.y)
                ,new Vector2(vecTo.x-vecFrom.x,vecTo.y-vecFrom.y-thickness)
                ,new Vector2(0,0-thickness)});

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        tmpBody.createFixture(fixtureDef);
    }