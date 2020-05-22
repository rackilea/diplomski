db.execSQL("CREATE TABLE IF NOT EXISTS " + MS_GROUP_DETAIL + " ("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + GROUP_ID + " INTEGER, " + MEMBER_USERNAME
                + " TEXT,  FOREIGN KEY (" + MEMBER_USERNAME
                + ") REFERENCES " + MS_MEMBER + "(" + MEMBER_USERNAME
                + "), FOREIGN KEY (" + GROUP_ID + ") REFERENCES "
                + MS_GROUP + "(" + GROUP_ID + "));");