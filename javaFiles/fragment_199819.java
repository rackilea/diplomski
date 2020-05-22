String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " 
            + DATABASE_TABLE + "("
            + patient_id + " INTEGER PRIMARY KEY AUTOINCREMENT, " 
            + patient_phone + " TEXT, " 
            + patient_name + " TEXT, " 
            + patient_phone + " TEXT  )";

 db.execSQL(CREATE_TABLE);