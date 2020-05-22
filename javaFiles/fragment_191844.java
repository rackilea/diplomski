interface LocationValidatable {
    default boolean hasValidLocation() {
      return false;
    }
}

interface Collidable extends LocationValidatable {
    default boolean hasValidLocation() {
      return true; // replace with actual logic
    }
}

interface NotCollidable extends LocationValidatable {
    default boolean hasValidLocation() {
      return false; // replace with actual logic
    }
}

abstract class GameObject implements LocationValidatable {
    //some more code that will use hasValidLocation
}