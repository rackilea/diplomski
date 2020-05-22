/** Creates a stage with a {@link ScalingViewport} set to {@link 
        Scaling#stretch}. The stage will use its own {@link Batch}
    *   which will be disposed when the stage is disposed. */
 public Stage () {
    this(new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), 
    Gdx.graphics.getHeight(), new OrthographicCamera()), new SpriteBatch());
    ownsBatch = true;
  }