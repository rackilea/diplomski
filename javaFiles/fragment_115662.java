@PersistenceCapable(identityType = IdentityType.APPLICATION, detachable="true")
public class Note {
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Long key;
...
}