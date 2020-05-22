public class LazySingleton{
    private LazySingleton(){}
    private static class Holder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }
    public static LazySingleton getInstance(){ return Holder.INSTANCE; }

}