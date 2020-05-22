World world=new World(new Vector2(0,-9.8f),true);

BodyDef bodyDef=new BodyDef();
bodyDef.position.set(100,100);
bodyDef.type= BodyDef.BodyType.DynamicBody;

Body body =world.createBody(bodyDef);    // body created

PolygonShape polygonShape=new PolygonShape();
polygonShape.setAsBox(2,2);
body.createFixture(polygonShape,1);

world.destroyBody(body);   // body destroyed