@MappedSuperclass
public abstract class AuditInfo implements Serializable {

...

    @PrePersist
    void onCreate() throws SQLException {
        //this empty method is needed for AOP to trigger the audit information insert before entity is stored
    }

    @PreUpdate
    void onPersist() throws SQLException {
        //this empty method is needed for AOP to trigger the audit information insert before entity is updated
    }

    @PreRemove
    void onRemove() throws SQLException {
        //this empty method is needed for AOP to trigger the audit information insert before entity is removed
    }
}