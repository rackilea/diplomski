public class ObjImpl extends ParentObject{
    //Concrete implementation
}

public class ObjImpl2 extends ParentObject{
    //Concrete implementation
}

public class TestClass{
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

    public static void main(String[] args) {
        ParentObject object1    = new ObjImpl();
        ParentObject object2    = new ObjImpl2();

        setPlayerFriction(object1, 1.0d, 2.0d);
        setPlayerFriction(object2, 2.25d, 2.0d);
    }
}