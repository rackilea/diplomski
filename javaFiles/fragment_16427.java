public abstract class EntityMetadata {
    private LocalDateTime creationTimestamp;
    private LocalDateTime lastModificationTimestamp;
    private Long version;
    // setters and getters
}

public abstract class BaseEntity<ID extends Serializable>
extends EntityMetadata implements Entity<ID> {
    private ID id;
    // setters and getters
}