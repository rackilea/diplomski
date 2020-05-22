public void update(float delta) {
    if(collides(rond)){
        rond.yspeed = -rond.yspeed;
    }else{
        rond.y+=rond.yspeed*delta;
    }
}