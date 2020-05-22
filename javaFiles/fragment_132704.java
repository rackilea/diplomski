public static final String CREATE_TABLE =
    "CREATE TABLE " + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_PRODUCT_ID + " TEXT UNIQUE,"
            + COLUMN_NAME + " TEXT,"
            + COLUMN_MAIN_IMAGE + " TEXT,"
            + COLUMN_MRP_PRICE + " INTEGER , "
            + COLUMN_DISCOUNT_PRICE + " INTEGER , "
            + COLUMN_QUANTITY + " INTEGER" +")";