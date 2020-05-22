@PrePersist
private void prePersist() {
    if(null == getMaster().getDependant()) {
        getMaster().setDependant(this);
    }
}