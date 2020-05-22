public final class Builders {

    public static Builder<? extends Sprite> newGameObjectBuilder() {
        return new GameObjectImpl.GameObjectBuilder();
    }

}