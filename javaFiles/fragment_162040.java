public final class Singleton$ implements Serializable, ScalaObject
{
    public Object readResolve()
    {
        return MODULE$;
    }

    private Singleton$()
    {
    }

    public static final Singleton$ MODULE$ = new Singleton$1();
}