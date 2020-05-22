public abstract class BaseEntity {
    public Optional<BaseEntity> getParent() {
        // subclass should override this method to return the parent entity
        return Optional.empty();
    }
    public void updateChain() { 
        // update your desired fields
        ...
        this.getParent().ifPresent(p -> p.updateChain());
    }
}