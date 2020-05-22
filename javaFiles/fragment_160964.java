public void setPlayerFriction(ParentObject objectType, double hspeed, double vspeed){

    double hSpeed = objectType.gethSpeed();
    if(hSpeed >= GameWindow.friction){
          objectType.sethSpeed(hSpeed - GameWindow.friction);
    }else if(hSpeed <= -GameWindow.friction){
          objectType.sethSpeed(hSpeed + GameWindow.friction);
    }else{
          objectType.sethSpeed(0);
    }

    double vSpeed = getvSpeed();
    if(vSpeed >= GameWindow.friction){
          objectType.setvSpeed(vSpeed - GameWindow.friction);
    }else if(obj.vspeed <= -GameWindow.friction){
          objectType.setvSpeed(vSpeed + GameWindow.friction);
    }else{
          objectType.setvSpeed(0);
    }
}