public void move(float x, float y) {

    boolean intersectedBlock = false;

    for (int i = 0; i < blocks.size(); i++) {
        Rectangle r = blocks.get(i);
        Rectangle p = new Rectangle(xx + x, yy + y, 32, 32);

        if (r.intersects(p)) {
            intersectedBlock = true;
            break;
        }
    }

    if (intersectedBlock) {
        xx = xp;
        yy = yp;
        xx += 0;
        yy += 0;
        System.out.println("Collide" + new Date());
    } else {
        xp = xx;
        yp = yy;
        xx += x;
        yy += y;
    }
}