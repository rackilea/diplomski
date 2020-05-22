private float restrictAngle(float tmpAngle){
    while(tmpAngle>=180) tmpAngle-=360;
    while(tmpAngle<-180) tmpAngle+=360;
    return tmpAngle;
}

//x is a raw angle value from getOrientation(...)
//y is the current filtered angle value
private float calculateFilteredAngle(float x, float y){ 
    final float alpha = 0.1f;
    float diff = x-y;

    //here, we ensure that abs(diff)<=180
    diff = restrictAngle(diff);

    y += alpha*diff;
    //ensure that y stays within [-180, 180[ bounds
    y = restrictAngle(y);

    return y;
}