public class Mongo {
    private static volatile Mongo instance;
    private Mongo() {
        ...
    }

    public static Mongo getInstance() {
        if (instance == null) {
            synchronized (Mongo.class) {
                if (instance == null) { // yes double check
                    instance = new Mongo();
                }
            }
        }

        return instance;
    }
}