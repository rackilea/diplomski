public abstract class LastActionHero<H extends Hero>(){
    protected final Class<H> hClass;
    protected LastActionHero(Class<H> hClass) {
        this.hClass = hClass;
    }
    // use hClass how you like.
}