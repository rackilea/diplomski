public abstract class AbstractManager<
        T1 extends AbstractObject, T2 extends AbstractObject>
        extends OtherManager
{
    public abstract T1 get(T1 obj);
    public abstract T1 put(T2 obj);
}