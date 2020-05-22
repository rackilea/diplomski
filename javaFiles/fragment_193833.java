String CREATE_ALERT_TABLE = "CREATE TABLE " + Constants.TABLE_NAME + " ("
                + Constants.KEY_ID + " INTEGER PRIMARY KEY,"
                + Constants.KEY_PARTY_NAME + " TEXT,"
                + Constants.KEY_CHEQUE_NUMBER + " TEXT,"
                + Constants.KEY_AMOUNT + " TEXT,"
                + Constants.KEY_EXPIRY_DATE + " LONG,"
                + Constants.KEY_REMINDER_DATE + " LONG,"
                + Constants.KEY_REMINDER + " TEXT,"
                + Constants.KEY_BANK_NAME + " TEXT);";