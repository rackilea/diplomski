public abstract class A<T extends A.Tile> {
    public static interface Tile;

    protected abstract Class<? extends T> getTileClass();
}

public class B extends A {
    public static class MyTile implements A.Tile { }

    @Override
    protected Class<MyTile> getTileClass() {
        return MyTile.class;
    }
}