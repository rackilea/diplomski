public Animator(Texture spriteSheet, int cols, int rows){
    this.walkSheet = spriteSheet;
    this.cols = cols;
    this.rows = rows;
}

public void create() {
      TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth()/cols, walkSheet.getHeight()/rows);              // #10
      anim = new Animation[rows];
      for (int i = 0; i < rows; i++) {
       walkFrames = new TextureRegion[cols];
       for (int j = 0; j < cols; j++) {
          walkFrames[j] = tmp[i][j];
        }
      anim[i] = new Animation(0.025f, walkFrames);
      }
      stateTime = 0f;                         // #13
    }

public void render(int index, SpriteBatch spriteBatch, int x, int y, int width, int height) {
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    stateTime += Gdx.graphics.getDeltaTime();
    currentFrame = anim[index].getKeyFrame(stateTime, true);
    spriteBatch.draw(currentFrame, x, y, width, height);
}