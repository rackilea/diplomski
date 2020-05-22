public void rotate(float angle){
    this.rotation = angle;

    double cos = Math.cos(rotation);
    double sin = Math.sin(rotation);

    double xOffset = (x[0]+x[2])/2;
    double yOffset = (y[0]+y[2])/2;

    for(int i = 0; i < 3; i++){
        x[i] = (float)(cos * (x[i]-xOffset) - sin * (y[i]-yOffset)) + xOffset;
        y[i] = (float)(sin * (x[i]-xOffset) + cos * (y[i]-yOffset)) + yOffset;

    }

}