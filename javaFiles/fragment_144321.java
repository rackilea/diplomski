int minRadius = 100;
    Random random = new Random();//define this outside you onDraw fucntion 
    int w = getWidth();
    int h = getHeight();

    int randX = random.nextInt(w);
    int randY = random.nextInt(h);
    int randR = minRadius + random.nextInt(100);
    ...
    c.drawCircle(randX, randY, randR, p);