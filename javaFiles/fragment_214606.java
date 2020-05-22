// Child entity's composite primary key
@Embeddable
public class InstanceNotifyEntityId implements Serializable {
    Long eaihId;
    Long userId;
}

// Child entity
@Entity
@Table(name="EIF_INST_NOTIFIED")
public class InstanceNotifyEntity implements Serializable {
    @AttributeOverrides({
      @AttributeOverride(name="userId", column = @Column(name="USER_ID"))
      @AttributeOverride(name="eaihId", column = @Column(name="EAIH_ID"))
    })
    @EmbeddedId
    InstanceNotifyEntityId id;

    @MapsId("eaihId")
    @ManyToOne
    InstanceEntity instance;

    // ...
 }