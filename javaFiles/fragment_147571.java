public class TV extends GameObject implements Serializable, IClusterable {
    private static final long serialVersionUID = 1L;

    public TV(String name, boolean activatable, boolean obstacle) {
        super(name, activatable, obstacle);
    }

    @Override
    public void doButtonOneActivity() {
        if(isActivatable()){
            // do whatever I need to do as a TV when I am activated...
           }
           if (isObstacle()){
            // do whatever I need to do as a TV when I am activated as an obstacle...
           }
           System.out.println("I'm a TV and I was called. My name is: " + getName()); 

    }
}