public final class Singleton{
    private Singleton(){}
    private static class Holder{
        private static final Singleton INSTANCE = new Singleton();
    }
    public Singleton getInstance(){return Holder.INSTANCE;}
}