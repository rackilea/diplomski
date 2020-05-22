@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

    protected T id;

    // fields, constructors, methods etc
}