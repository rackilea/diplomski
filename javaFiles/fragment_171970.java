buffer = new FrameBuffer(Pixmap.Format.RGBA8888,Settings.WIDTH,Settings.HEIGHT,false);

    ShaderProgram.pedantic=false;
    shader = new ShaderProgram(Gdx.files.internal("shaders/pass.vert"),Gdx.files.internal("shaders/scanlines.frag"));
    shader.begin();
    shader.setUniformf("uResolution",(float)Settings.WIDTH,(float)Settings.HEIGHT);
    shader.end();