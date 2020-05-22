public static void main(String[] args)
{
    ActorWorld world = new ActorWorld();
    world.add(new GrowingFlower(world)); // Pass it in here!
    world.show();
}