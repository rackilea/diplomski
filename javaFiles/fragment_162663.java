public interface ThrowableItem {
   void throwAt(Wall wall);
}

public class Wall {
    void accept(ThrowableItem item) {
        item.throwAt(this);
    }
}