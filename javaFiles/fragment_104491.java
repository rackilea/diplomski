public class MyCanvas extends Canvas
    Graphics3D g3d;
    World world;
    int currentTime = 0;

    public MyCanvas() {
        g3d = Graphics3D.create();
        Object root[] = Loader.load("world.m3g");
        world = root[0];
    }

    protected void paint(Graphics g) {
        g3d.bindTarget(g);
        world.animate(currentTime);
        currentTime += 50;
        g3d.render(world);
        g3d.releaseTarget();
    }
}