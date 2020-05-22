public class anEntity extends Model {
    @Transient
    private TransientSingleton t;

    public anEntity(){ // JPA calls this so you can use the constructor to set the transient instance.
        super();
        t=TransientSingleton.getInstance();
    }


public class TransientSingleton { // simple unsecure singleton from wikipedia

    private static final TransientSingleton INSTANCE = new TransientSingleton();
    private TransientSingleton() {
        [...do stuff..]
    }
    public static TransientSingleton getInstance() {
        return INSTANCE;
    }
}