int rotation = Gdx.input.getRotation();
if((Gdx.input.getNativeOrientation() == Input.Orientation.Portrait && (rotation == 90 || rotation == 270)) || //First case, the normal phone
        (Gdx.input.getNativeOrientation() == Input.Orientation.Landscape && (rotation == 0 || rotation == 180))) //Second case, the landscape device
    Gdx.app.log("Orientation", "We are in landscape!");
else
    Gdx.app.log("Orientation", "We are in portrait");