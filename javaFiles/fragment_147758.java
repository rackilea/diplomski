public class IntPair { private final int x, y; /* Constructor, getters */ }

// Creation:
for(int x = 0; x < width; x++) {
    for(int y = 0; y < height; y++) {
        Actor actor = new Actor();
        actor.setUserObject(new IntPair(x, y));
    }
}

// Accessing index:
IntPair index = (IntPair) actor.getUserObject();