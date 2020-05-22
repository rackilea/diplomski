public class Dog extends Animal {
    private boolean _graduated = true;

    @Override
    public boolean isGraduated() {
        return _graduated; //or some complex logic that determines graduation
    }
}