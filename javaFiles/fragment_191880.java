@Component
@RepositoryEventHandler
@DependsOn("myBean")
public class MyEventHandler {

    @HandleBeforeCreate
    public void beforeCreateInstance(Object instance) {
         ...
    }
}