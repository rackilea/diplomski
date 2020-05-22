public class GrowingFlower extends Flower {

    private int Growing = (int) (Math.random() * 4);
    private int age = 0;

    ActorWorld world; // Don't create a new world here!

    // Instead, use the world that is passed in 
    // in the constructor:
    GrowingFlower(ActorWorld world)
    {
        this.world = world;
    }

    ...