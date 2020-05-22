class ModelName {
    public static void createTable(SQLiteDatabase db){
        System.out.println(Thread.currentThread().getStackTrace()[1]);
    }

    public static void deleteTable(SQLiteDatabase db){
        System.out.println(Thread.currentThread().getStackTrace()[1]);
    }
}

class OtherModelName {
    public static void createTable(SQLiteDatabase db){
        System.out.println(Thread.currentThread().getStackTrace()[1]);
    }

    public static void deleteTable(SQLiteDatabase db){
        System.out.println(Thread.currentThread().getStackTrace()[1]);
    }
}