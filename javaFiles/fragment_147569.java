public class Game implements Serializable, IClusterable {
    private static final long serialVersionUID = 1L;

    private ArrayList<GameObject> gameObjects;

    public void actionPerformed(GameObject current) {

        // Let the object do whatever it's supposed to do on button press, in either case.
        current.doButtonOneActivity();

        if(current.isActivatable()){
            // Do whatever extra thing you need to do if this one is Activatable...
            System.out.println("Hey, this thing is activatable!");
        } else if (current.isObstacle()){
            // Do something an obstacle needs you to do
            System.out.println("Hey, this thing is an obstacle!");
        }

    }
}