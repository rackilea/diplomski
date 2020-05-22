BooleanBinding collision = Bindings.createBooleanBinding( () -> 
    ball.getBoundsInParent().intersects(rect.getBoundsInParent()),
    ball.boundsInParentProperty(),
    rect.boundsInParentProperty());

collision.addListener((obs, wasColliding, isNowColliding) -> {
    if (isNowColliding) {
        // foo
    }
});