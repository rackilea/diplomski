int monitorWidth = 0;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] screenDevices = ge.getScreenDevices();
    if(screenDevices.length > 0){
        monitorWidth = screenDevices[0].getDisplayMode().getWidth();
    }


    Point ownerLocationOnScreen = owner.getLocationOnScreen();

    int screenMovingX = 0;
    if(ownerLocationOnScreen.x < 0){
        screenMovingX = -monitorWidth;
    }
    if(ownerLocationOnScreen.x > monitorWidth){
        screenMovingX = monitorWidth;
    }