class MySingleton {

public static String myTrigger="a trigger";

    private MySingleton(){
        System.out.println("Printing");
    }

    public static enum LazyLoad {
        IMDB_LOOKUP_INSTANCE;
        public static final String Hello = "Hello";
        private static final MySingleton IMDB_LOOKUP = new MySingleton();
    }

    public static MySingleton getInstance() {
        return LazyLoad.IMDB_LOOKUP_INSTANCE.IMDB_LOOKUP;
    }
}