SpriteBatch batch = new SpriteBatch();
Texture texture = new Texture(Gdx.files.internal("data/libgdx.png"));
texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

int textureWidth = texture.getWidth();
int textureHeight = texture.getHeight();
float rotationAngle = 90f;

TextureRegion region = new TextureRegion(texture, 0, 0, textureWidth, textureHeight);

batch.begin();
batch.draw(region, 0, 0, textureWidth / 2f, textureHeight / 2f, textureWidth, textureHeight, 1, 1, rotationAngle, false);
batch.end();