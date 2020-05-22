public static void main(String[] args) {
    Test t = new Test();

    for (int i = 0; i < 360; i++) {
        t.setVelocityOnAxis(i, 10);
        System.out.println("Angle: " + i + " vx: " + t.vx + " vy: " + t.vy);
        System.out.println("getPointDir: " + t.getPointDir(t.vx, t.vy));
    }

}