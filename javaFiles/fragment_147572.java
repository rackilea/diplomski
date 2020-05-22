public class Wall extends GameObject implements Serializable, IClusterable {
    private static final long serialVersionUID = 1L;

    public Wall(String name, boolean activatable, boolean obstacle) {
        super(name, activatable, obstacle);
    }

    @Override
    public void doButtonOneActivity() {    
        if(isActivatable()){
         // do whatever I need to do as a Wall when I am activated...
        }
        if (isObstacle()){
         // do whatever I need to do as a Wall when I am activated as an obstacle...
        }
        System.out.println("I'm a wall and I was called. My name is: " + getName()); 

    }
}