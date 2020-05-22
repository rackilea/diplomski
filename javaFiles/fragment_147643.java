private final Vector2 vecBodySize1 = new Vector2(100,50);
private final Vector2 vecBodySize2 = new Vector2(110,70);

private void createBodies(){
Body body1, body2;

BodyDef bodyDef = new BodyDef();
bodyDef.type = BodyDef.BodyType.StaticBody;
bodyDef.position.set(YOUR_POSITION.x, YOUR_POSITION.y);

body1 = world.createBody(bodyDef);

PolygonShape shape = new PolygonShape();
shape.setAsBox(vecBodySize1.x, vecBodySize1.y);

FixtureDef fixtureDef = new FixtureDef();
fixtureDef.shape = shape;
fixtureDef.density = 1f;
body1.createFixture(fixtureDef);

BodyDef bodyDef2 = new BodyDef();
bodyDef2.type = BodyDef.BodyType.StaticBody;
bodyDef2.position.set(YOUR_POSITION2.x, YOUR_POSITION2.y);

body2 = world.createBody(bodyDef2);

PolygonShape shape2 = new PolygonShape();
shape2.setAsBox(vecBodySize2.x, vecBodySize2.y);

FixtureDef fixtureDef2 = new FixtureDef();
fixtureDef2.shape = shape2;
fixtureDef2.density = 1f;
body2.createFixture(fixtureDef2);

///
// The body object gonna take the center position as default, this way you can set where the bridge starts and ends with 2 simple vectors
// you can set the thickness variable as you want to be the size of the bridge, never leave this null or 0
///
Vector2 vecBridge1 = new Vector2(body1.getPosition().x+vecBodySize1.x,body1.getPosition().y+vecBodySize1.y);
Vector2 vecBridge2 = new Vector2(body2.getPosition().x-vecBodySize2.x,body2.getPosition().y+vecBodySize2.y);
createBridge(vecBridge1,vecBridge2, 10.0f);
}