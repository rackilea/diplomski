public void moveCameraPos(int dir, Player p, int delta){
        switch(dir){

        default:
            break;
        case Play.UP:
            if(camera.posY>0)
                camera.posY -= (delta * .1f) * p.speed /2;
            break;
        case Play.DOWN:
            if(camera.posY < 735 - 490)
                camera.posY += (delta * .1f) * p.speed /2;
            break;
        case Play.LEFT:
            if(camera.posX > 0)
                camera.posX -= (delta * .1f) * p.speed /2;
            break;
        case Play.RIGHT:
            if(camera.posX < 1260 - 840)
                camera.posX += (delta * .1f) * p.speed /2;
            break;
        case Play.UPRIGHT:
            if(camera.posX>0 && camera.posY>0){ 
                camera.posY -= ((delta * .1f) * p.speed)/2;
                camera.posX += ((delta * .1f) * p.speed)/2;
            }
                break;
        case Play.UPLEFT:
            if(camera.posX>0 && camera.posY>0){ 
                camera.posY -= ((delta * .1f) * p.speed)/2;
                camera.posX -= ((delta * .1f) * p.speed)/2;
            }
            break;
        case Play.DOWNRIGHT:
            if(camera.posX < 1260 -840 && camera.posY<735-490){ 
                camera.posY += ((delta * .1f) * p.speed)/2;
                camera.posX += ((delta * .1f) * p.speed)/2;
            }
            break;  
        case Play.DOWNLEFT:
            if(camera.posX > 0 && camera.posY<735-490){ 
                camera.posY += ((delta * .1f) * p.speed)/2;
                camera.posX -= ((delta * .1f) * p.speed)/2;
            }
            break;
    }
}