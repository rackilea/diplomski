//in the show() method
    viewport = new ExtendViewport(SCREEN_WIDTH, Runner.SCREEN_HEIGHT/3);
    stage.setViewport( viewport );

    //in the render method
    viewport.update(currentWindowWidth, currentWindowHeight/3); //set the currentWindow... variables in the resize method to keep proper ratio
    stage.act();
    stage.draw();