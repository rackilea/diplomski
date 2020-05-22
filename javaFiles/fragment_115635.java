@PreUpdate
protected void onUpdate() {
    letztesAenderungsdatum = new Date();
}

@PrePersist
protected void onPersist() {
    letztesAenderungsdatum = new Date();
}