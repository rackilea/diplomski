public class Copier {
    ...
    public static Copier getInstance() {
        return Holder.instance;
    }
    ...
    private static class Holder {
        private static final Copier instance = new Copier();
    }
}