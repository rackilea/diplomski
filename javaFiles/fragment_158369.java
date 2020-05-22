while (running) {
    delta += (now - lastTime) / ns;
    lastTime = now;
    if (delta >= 1) {
        tick();
        delta--;
    }
    render();
}