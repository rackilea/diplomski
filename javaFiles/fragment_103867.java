public float getAnimationSpeed()
{
    float _absVel = Math.abs(_vel.x);
    float offset = 0; //whatever you want

    if(_absVel<=10){
        return 0f;
    }
    else{
        return ((1/_absVel)+offset)f;
    }
}