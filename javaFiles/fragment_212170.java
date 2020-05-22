public void render(float delta){
    //code to render splash here

    //check if assets are loaded and time greater than 10 seconds
    if(assetManager.update() && TimeUtils.timeSinceMillis(startTime) > 10000){
        app.setScreen(new MainScreen());
    }
}