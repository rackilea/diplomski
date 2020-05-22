public void run(){
    this.requestFocus();
    long lastTime = System.nanoTime();
    double amountOfTicks = 60.0;
    double ns = 1000000000/amountOfTicks;
    double delta = 0;
    long timer = System.currentTimeMillis();
    int frames = 0;
    int ticks = 0;

    long renderLastTime=System.nanoTime();
    double amtOfRenders = 200.0;//MAX FPS
    double renderNs=1000000000/amtOfRenders;
    double renderDelta = 0;

    while(running){
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while(delta >= 1){
            tick();
            ticks++;
            delta--;
        }

        now = System.nanoTime();
        renderDelta += (now - renderLastTime) / renderNs;
        renderLastTime = now;
        while(running && renderDelta >= 1){
            render();
            frames++;
            renderDelta--;
        }

        if(System.currentTimeMillis() - timer > 1000){
            timer += 1000;
            System.out.println("FPS: " + frames);
            System.out.println("Ticks per second: " + ticks);
            frames = 0;
            ticks = 0;
        }
    }
    stop();
}