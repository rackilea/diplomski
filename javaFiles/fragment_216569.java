// EDIT
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MyEntity {
   @Transient
   private transient MyEntity savedState;

}

public class AuditEntityListener {
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    private static final Marker AUDIT = MarkerFactory.getMarker("AUDIT");

@PostLoad
 private void saveState(MyEntity target){

    target.savedState = SerializationUtils.clone(target);
 }

@PrePersist
public void prePersist(MyEntity target) {
    log("new object inserted", target);
}

@PreRemove
public void preRemove(MyEntity target) {
    log("entity deleted", target);
}

@PreUpdate
public void preUpdate(MyEntity target) {
    MyEntity previousState = target.getSavedState();
}