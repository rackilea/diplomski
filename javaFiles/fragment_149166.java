abstract class ObjectController<T extends GameObject> {
    protected T gameObject;
    protected Game gameVersion;

    public ObjectController(T object, Game gameVersion){
        this.gameObject = object;
        this.gameVersion = gameVersion;
    }
    public abstract void nextAction();
}

class PlayerController extends ObjectController<Player> {

    public PlayerController(Player object, Game gameVersion) {
        super(object, gameVersion);
    }

    @Override
    public void nextAction() {
        //Work with your Player here
    }

}