//No need to create your own camera. ExtendViewport creates its own.

// Pointless to call this now before resize method is called. Call this in render
//XXX this.spriteBatch.setTransformMatrix(this.orthoCamera.combined);

//This is where you give the viewport its minimum virtual dimensions
this.viewPort = new ExtendViewport(Configuration.VIRTUAL_GAME_WIDTH, Configuration.VIRTUAL_GAME_HEIGHT);

//Get reference to the viewport's camera for use with your sprite batch:
this.orthoCamera = (OrthographicCamera) this.viewport.getCamera();