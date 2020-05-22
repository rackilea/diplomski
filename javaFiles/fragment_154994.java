public interface CollidingDetectionPolicy <T extends GameObejct> {

    boolean objectsColliding(T object1,T object2);

}

public class SimpleCollisionDetector implements CollidingDetectionPolicy<GameObejct> {
    @Override
    public boolean objectsColliding(GameObejct object1, GameObejct object2) {
       // detect collision using a simple method...
        return false;
    }
}

public class ComplexCollisionDetector implements  CollidingDetectionPolicy<GameObejct> {
    @Override
    public boolean objectsColliding(GameObejct object1, GameObejct object2) {
        // detect collision using some other more complex method
        return false;
    }
}