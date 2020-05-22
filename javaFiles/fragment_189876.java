Animation animation;

    ...

    TextureRegion[] frames = animation.getKeyFrames();
    int currentFrameId = 0;

    ...

    if( clickedOnSomething() ) //let the clickedOnSomething method return true when clicked
    {
        currentFrameId++; //or another change due to some conditions
    }

    ...

    batch.draw(frames[currentFrameId], x, y);