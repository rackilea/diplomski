public class GameEngine {

    public void detectCollisions() {

        /// ...
        /// ...
        // need to know if there is some collision

        // get all the objects on screen and the current collision detection policy (see note)  
        List<GameObejct> currentlyVisibleObjects = getObjectsOnScreen();
        CollidingDetectionPolicy collisionDetector = getCollisionDetectionLogic();

        // naive implementation . don't traverse your list this way!Think about complexity!
        for (int i = 0; i < currentlyVisibleObjects.size() - 1; i++) {
            GameObejct object1 = currentlyVisibleObjects.get(i);

            for (int j = i + 1; j < currentlyVisibleObjects.size(); j++) {
                GameObejct object2 = currentlyVisibleObjects.get(j);
                if (collisionDetector.objectsColliding(object1, object2)) {
                    // object colliding ...do something
                }
            }
        }

    }

    public List<GameObejct> getObjectsOnScreen () {
        ... // return the list of game objects
    }

    public CollidingDetectionPolicy getCollisionDetectionLogic() {
        ... /// return the detection implementation 
    }
}