@PrePersist
private void prePersist() {
    if(null == getDependant().getMaster()) {
        getDependant().setMaster(this);
    }
}