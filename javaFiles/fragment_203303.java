void draw() {

    if ( secondDelay(5) ) {
        drawCar(v,b,50,0);
        v = (int)random(0,width);
        b = (int)random(0,height);
    }
}