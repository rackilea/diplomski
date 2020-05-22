public class Singleton {

    private static Singleton singleton;

    public static Singleton getDefault() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }

    /**
     * The constructor.
     */
    private Singleton() {
        System.out.println(singleton);
        if (singleton == null) {
                /*this will call a default constructor
                 *and instantiate Singleton object
                 */
            singleton = this;
        }
    }

    public void Print() {
        System.out.println("I'm a singleton!");
    }


    public static void main(String[] args) {
        Singleton singleton = Singleton.getDefault();
        System.out.println(singleton.Print());
    }
}