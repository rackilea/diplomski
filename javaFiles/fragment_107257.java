//To Measure FPS
private long now;
private int framesCount = 0;
private int framesCountAvg=0; 
private long framesTimer=0;

//Main Game Loop
    while (isRunning)
    {
        //Record the time before update and draw
        long beforeTime = System.nanoTime();
        //... Update program & draw program...
        // DRAW FPS: 
        now=System.currentTimeMillis(); 
        gEngine.drawFPS(c, framesCountAvg);
        framesCount++; 
        if(now-framesTimer>1000)
        { 
              framesTimer=now; 
              framesCountAvg=framesCount; 
              framesCount=0; 
        }}