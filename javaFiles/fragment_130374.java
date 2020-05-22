class BirdAction {
    static void fly(Bird bird) {
        // Check if this Bird implements the Flyable interface
        if (bird instanceof Flyable) {
            // All birds fly like this
        } else {
            // This bird tried to fly and failed
        }
    }
}