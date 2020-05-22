@Entity
@Data
public class MyClass {
    @Delegate
    @EmbeddedId
    private PrimaryKey id;
}