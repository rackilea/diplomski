public Optional<RollingStock> getHeadPoint() {
    if (!train.isEmpty()) {
        // or even Optional.ofNullable, if you are not sure 
        // whether train.get(0) is null or not 
        return Optional.of(train.get(0));  
    } else {
        return Optional.empty();
    }
}