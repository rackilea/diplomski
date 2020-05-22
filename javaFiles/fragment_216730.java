package ca.patrick.main.window;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;

import ca.patrick.main.framework.GameObject;
import ca.patrick.main.framework.Id;
import ca.patrick.main.objects.Enemy1;

public class Game extends Canvas implements Runnable{

    private static final long serialVersionUID = -4319386659730073928L;

    public int WIDTH, HEIGHT;
    public boolean running = false;
    private Thread thread;

    private LinkedList<GameObject> object;
    private Enemy1 e;

    private void init() {
        HEIGHT = getHeight();
        WIDTH = getWidth();

        e = new Enemy1(200, 200, Id.Enemy);
    }
    public synchronized void start(){
        if(running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        init();
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int updates = 0;
    int frames = 0;
    while (running) {
        long now = System.nanoTime();
        delta += (now - lastTime) / ns;
        lastTime = now;
        while (delta >= 1) {
            tick();
            updates++;
            delta--;
        }
        render();
        frames++;

        if (System.currentTimeMillis() - timer > 1000) {
            timer += 1000;
            System.out.println("FPS: " + frames + " TICKS: " + updates);
            frames = 0;
            updates = 0;
        }
    }
}



private void tick() {
    e.tick(object);
}

private void render() {
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null){
        this.createBufferStrategy(3);
        return;
    }

    Graphics g = bs.getDrawGraphics();

    g.setColor(Color.cyan);
    g.fillRect(0, 0, getHeight() * 2, getWidth() * 2);

    e.render(g);

    bs.show();
    g.dispose();
}

public Game(){

}

public static void main(String args[]){
    new Window(600, 800, "Log Platformer prototype", new Game());
}