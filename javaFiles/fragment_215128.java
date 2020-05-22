long now = System.nanoTime();
    delta += (now - lastTime) / ns;
    lastTime = now;
    while (delta >= 1)
    {
        tick();
        delta--;
    }