public abstract class Foo implements Serializable {

    private int a;
    private String b;

    public Foo(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public abstract void run();

    public int getA() { return a; }

    public String getB() { return b; }

    public final Foo copy() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            new ObjectOutputStream(baos).writeObject(this);
            return (Foo) new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray())).readObject();
        } catch (Exception e) {
            throw new AssertionError(); 
        }
    }
}