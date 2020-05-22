public class AuditEntityListener {

@PrePersist
public void prePersist(AuditableEntity e) {
    e.setCreatedDate(new Date());
    //In my case
     e.setCreatedBy((User) RequestContext.getAttribute("user"));
}

@PreUpdate
public void preUpdate(AuditableEntity e) {
    e.setLastModifiedDate(new Date());
}