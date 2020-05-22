final class Singleton {

    private Singleton() {
        // Make sure only I can create one.
    }

    private enum Single {

        INSTANCE;
        // The only instance - ever.
        final Singleton s = new Singleton();

    }

    public static Singleton getInstance() {
        // Will force the construction here only.
        return Single.INSTANCE.s;
    }
}