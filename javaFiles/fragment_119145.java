@PrePersist
protected void onCreate() {
    if (created == null) {
        created = new Date();
    }
}