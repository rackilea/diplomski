@PrePersist
public void prePersist() throws IOException {
    Logger.warn("PrePersist called");
}

@PreUpdate
public void preUpdate() throws IOException {
    Logger.warn("PreUpdate called");
}

@PostLoad
public void postLoad() throws IOException {
    Logger.warn("PostLoad called");
}