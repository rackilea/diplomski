public abstract class A {
    public static interface Tile;

    protected abstract Class<? extends Tile> getTileClass();
}

public class B extends A {
    public static class MyTile implements A.Tile { }

    @Override
    protected Class<MyTile> getTileClass() {
        return MyTile.class;
    }
}