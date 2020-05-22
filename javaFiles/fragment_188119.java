@Entity
@Table(name = "my_entity")
public class SomeEntity extends BaseEntity {

public static final class MyValueGenerator implements
        ValueGenerator<String> {
    @Override
    public String generateValue(Session session, Object owner) {
        return "This is my default name";
    }
}

@Basic
@Column(name = "name", insertable = true, updatable = true, nullable = false, length = 255)
// This will add a DDL default
@ColumnDefault("'This is my default name'")
// This will add a runtime default.
@GeneratorType(type = MyValueGenerator.class)
private String name;

// getters and setters

}