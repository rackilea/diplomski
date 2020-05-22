public abstract class AbstractEntity {

    private final int id;
    private String name;


    protected AbstractEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void someMethods() {
        // A
    }

    protected abstract void someAbstractMethods();

}