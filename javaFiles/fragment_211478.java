public enum Level1 implements Explorable{
    ROOM1 {
        public void explore() {
            // fight monster
        }
    }, ROOM2 {
        public void explore() {
            // solve riddle
        }
    }, ROOM3 {
        public void explore() {
            // rescue maiden
        }
    };

}

public interface Explorable{
    public abstract void explore();    
}

public static void move(Explorable[] adjacentNodes, int index)
{
    adjacentNodes[index].explore();
}