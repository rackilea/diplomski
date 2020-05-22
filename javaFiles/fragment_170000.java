public abstract class Location<SELF extends Location<SELF>> {
    ...

    public Processor<SELF> processor() {
        return new Processor<>( self() );
    }

    protected abstract SELF self();
}

public class SecretLocation extends Location<SecretLocation> {
    ...

    @Override
    protected SecretLocation self() { return this; }
}