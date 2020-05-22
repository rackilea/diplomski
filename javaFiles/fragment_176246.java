Pixmap pixmap = new Pixmap(1,1, Pixmap.Format.RGBA8888);
pixmap.setColor(Color.BLACK);
pixmap.fillRectangle(0, 0, 1, 1);
Texture texture1=new Texture(pixmap);
pixmap.dispose();

Image semiTL=new Image(texture1);
semiTL.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
semiTL.getColor().a=.8f;
stage.addActor(semiTL);