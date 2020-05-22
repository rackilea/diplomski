@EntityListeners(class=Audit.class)
@Entity
public class MyUniqueObject implements Serializable {}


public class Audit {

    @Inject
    private Logger log;

    @Inject
    private Event<MyUniqueObjectEvent> events;

}