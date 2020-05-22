public boolean isCollision(){
    if(ufo.getX() + ufo.width() > pipe.getX() + pipe.getOffSetWidth() && ufo.getX() < pipe.getX() + pipe.width() - pipe.getOffSetWidth()){
        if(\\check for y value of height, this can be different depending on your way of storing pipes){
            return true;
        }
    } 
}