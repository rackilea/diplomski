@Entity(name = "EntityAAudit")
@Table(name = "audit")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("entity_a")
@DiscriminatorOptions(insert = true, force = true)
public class EntityAAudit extends Audit {

    @EmbeddedId
    @JsonUnwrapped
    private AuditedId id;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    @MapsId("entityAId") // maps entityAId attribute of embedded id
    private EntityA item;

    @Embeddable
    public static class AuditedId implements Serializable {
        private Long entityAId; // corresponds to PK type of EntityA

        @Column(name = "version", nullable = false)
        private Long version;
    }

}