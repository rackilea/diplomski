public enum EnumSingleton{
    INSTANCE;

    // and if you want, you can add the method, too, but it's
    // unnecessary:
    public static EnumSingleton getInstance(){ return INSTANCE; }
}