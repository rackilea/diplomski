private BufferedImage getCurrentAnimationFrame(){ //set Player animations when moving

    if(yMove > 0){
        return Assets.playerFall;
    }

    if(yMove < 0){
        return Assets.playerFall;
    }
    if(xMove > 0){
        facingRight = true;
        facingLeft = false;
        return animRight.getCurrentFrame();
    }
    if(xMove < 0){
        facingLeft = true;
        facingRight = false;
        return animLeft.getCurrentFrame();
    }

    if(facingLeft){
        return animLeft.getCurrentFrame();
    } else {
        return animRight.getCurrentFrame();
    }
}