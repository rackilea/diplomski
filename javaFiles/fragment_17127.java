public class StringCapListener {
    @PrePersist
    @PreUpdate
    public void capitalize(Object o) {
      // capitalize string attributes
    }
    ...