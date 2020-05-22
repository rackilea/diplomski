BitmapFont                      fontWinFail; 
fontWinFail = manager.get("fontWinFail.ttf", BitmapFont.class);//notice same name used in above segment(NOTE that this is just a name, not the name of the file)         
fontWinFail.setColor(Color.BLACK);

//Then on your render() method
fontWinFail.draw(batch, "hello world", Gdx.graphics.getWidth()*0.5f, Gdx.graphics.getHeight()*0.6f);