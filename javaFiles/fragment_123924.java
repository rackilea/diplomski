FixtureDef fdef = new FixtureDef();
    CircleShape shape = new CircleShape();
    shape.setRadius(6 / SuperMarioBros.PPM);
    fdef.filter.categoryBits = SuperMarioBros.MARIO_BIT;
    fdef.filter.maskBits = SuperMarioBros.DEFAULT_BIT | SuperMarioBros.COIN_BIT | SuperMarioBros.BRICK_BIT ;

    fdef.shape = shape;
    b2body.createFixture(fdef);

    FixtureDef fdef2 = new FixtureDef();
    EdgeShape feet = new EdgeShape();
    feet.set(new Vector2(-2 / SuperMarioBros.PPM, -6 / SuperMarioBros.PPM), new Vector2(2 / SuperMarioBros.PPM, -6 / SuperMarioBros.PPM));
    fdef2.filter.categoryBits = SuperMarioBros.MARIO_BIT;
    fdef2.filter.maskBits = SuperMarioBros.DEFAULT_BIT | SuperMarioBros.COIN_BIT | SuperMarioBros.BRICK_BIT ;
    fdef2.shape = feet;
    b2body.createFixture(fdef2);

    EdgeShape head = new EdgeShape();
    head.set(new Vector2(-2/SuperMarioBros.PPM, 6/SuperMarioBros.PPM), new Vector2(2/SuperMarioBros.PPM, 6/SuperMarioBros.PPM));
    fdef.shape = head;
    fdef.isSensor = true;

    b2body.createFixture(fdef).setUserData("head");