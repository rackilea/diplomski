@Entity
@Table(name = "myentity", uniqueConstraints = { 
  @UniqueConstraint(name = "theNameIWant"), columnNames={"somefield"},
  ... other constraints ...
}
)
public class SomeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(unique = true, nullable = false, name = "somefield")
    @NotNull
    private String somefield;
}