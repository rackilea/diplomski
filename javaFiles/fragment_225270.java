private Sprite sprite;
texture = new Texture(Gdx.files.internal("image.png"));
sprite = new Sprite(texture, 20, 20, 50, 50);
sprite.setPosition(10, 10);
sprite.setRotation(45);
sprite.setCenter(25, 25);
batch.begin();
sprite.draw(batch);
batch.end();