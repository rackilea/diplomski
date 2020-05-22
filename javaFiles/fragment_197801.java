public abstract class Plant {
    private String roots;
    private String trunk;

    // setters go here

    private void validate() {
        if (roots == null) throw new IllegalArgumentException("No roots!");
        if (trunk == null) throw new IllegalArgumentException("No trunk!");
        validateEx();
    }

    protected void validateEx() { }

    public abstract void grow();
}