TextureAtlas texture = new TextureAtlas(Gdx.files.internal("actors/MainChar/a.pack"));
Animation animation = new Animation<TextureRegion>(1/5f, texture.getRegions());

private TextureAtlas textureFF = new TextureAtlas(Gdx.files.internal("actors/MainChar/b.pack"));
Animation animation2 = new Animation<TextureRegion>(1/7f, textureFF.getRegions());
...
...
create number of Animation in your screen 


 MainChar mainChar=new MainChar(animation);
 stage.addActor(mainChar);