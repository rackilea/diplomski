public class Superclass {
    public Superclass() {
        try {
            // get the constructor with no arguments
            this.getClass().getConstructor();
        } catch(ReflectiveOperationException e) {
            throw new RuntimeException("Subclass doesn't have a no-argument constructor, or the constructor is not accessible", e);
        }
    }
}