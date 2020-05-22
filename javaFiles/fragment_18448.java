@Singleton
@Component(modules = MyModule.class)
public interface MyDiContainer {
    // ********************** CONTROLLERS **********************
    @Named("Controllers")
    Map<Class<?>, Provider<Object>> getControllers();
}