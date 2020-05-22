public class MyListener {

    CurrentUserProvider provider; // Implement this and make sure it is set

    @PreUpdate
    @PrePersist
    public void updateModifier(MyEntity entity) {
         entity.setModifiedOn(new Date());
         entity.setModifiedBy(provider.getCurrentUser());
    }
}