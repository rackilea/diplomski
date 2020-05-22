private Viewport viewport;

//in create:
viewport = new FitViewport(400, 400);

//in resize:
viewport.update(width, height);

//in render:
viewport.getCamera().position.set(/*...move your map camera as needed*/);
viewport.apply(); //viewport cropped to your red square
batch.setProjectionMatrix(viewport.getCamera().combined);
batch.begin();
//draw map
batch.end();

//return to full screen viewport
Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight()); 

batch.setProjectionMatrix(yourGUICamera.combined);
batch.begin();
//draw gui
batch.end();