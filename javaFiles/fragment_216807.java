@Component
class EntityListener {
    @PrePersist
    public void onPrePersist(Object o) {
        // encode logic
    }

    @PreUpdate
    public void onPreUpdate(Object o) {
        // encode logic
    }

    @PostLoad
    public void onPostLoad(Object o) {
        // decode logic
    }
}