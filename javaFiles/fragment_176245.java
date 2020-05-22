stage=new Stage();
Texture texture=new Texture("badlogic.jpg");

Image image=new Image(texture);
image.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("TouchTest","Clicked on Image");
            }
        });

stage.addActor(image);

Actor actor=new Actor();   // this is your transparent layer 
actor.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
stage.addActor(actor);

// Popup should on the top or your actor(touch layer) 

Image image1=new Image(texture);
image.setPosition(100,100);
stage.addActor(image1);

Gdx.input.setInputProcessor(stage);