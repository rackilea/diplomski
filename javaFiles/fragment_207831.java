public GameRenderer(int gameHeight) {
                   this.gameHeight = gameHeight;
                  cam = new OrthographicCamera();
                   batch = new SpriteBatch();
                   cam.setToOrtho(true, 136, gameHeight);
                   batch.setProjectionMatrix(cam.combined);

            }