@Module(includes={ThoseModule.class, TheseModule.class})
public abstract class SomethingModule {
    @Binds
    abstract Whatever whatever(WhateverImpl impl);
}

@Singleton
public class WhateverImpl implements Whatever {
    Those those;
    These these;

    @Inject
    public Whatever(Those those, These these) {
        this.those = those;
        this.these = these;
    }
}

@Component(modules={SomethingModule.class})
@Singleton
public interface SomethingComponent {
    These these();
    Those those();
    Whatever whatever();
}