@Module(includes = { OverrideModule.class })
public abstract class AppModule {
  @Binds
  @Singleton
  abstract MyService providesMyService(MyServiceImpl impl);
}