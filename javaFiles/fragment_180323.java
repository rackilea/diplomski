Texture t = assetManager.get("your texture", Texture.class);

BodyDef bodyDef = new BodyDef();
body.type = BodyType.DynamicBody

float width = 64 * WORLD_TO_BOX;
float height = 64 * WORLD_TO_BOX;

Shape shape = new PolygonShape();
float[] points = new float[]{0,0,width,0,width,height,0, height};
shape.set(points);
FixtureDef def = new FixtureDef();
def.shape = shape;
...
body.createFixture(def);
shape.dispose();