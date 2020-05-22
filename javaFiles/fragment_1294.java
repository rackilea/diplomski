ObservableBooleanValue colliding = Bindings.createBooleanBinding(new Callable<Boolean>() {

        @Override
        public Boolean call() throws Exception {
            return rect1.getBoundsInParent().intersects(rect2.getBoundsInParent());
        }

    }, rect1.boundsInParentProperty(), rect2.boundsInParentProperty());

    colliding.addListener(new ChangeListener<Boolean>() {
        @Override
        public void changed(ObservableValue<? extends Boolean> obs,
                Boolean oldValue, Boolean newValue) {
            if (newValue) {
                System.out.println("Colliding");
            } else {
                System.out.println("Not colliding");
            }
        }
    });