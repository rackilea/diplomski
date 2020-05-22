arg0.execSQL("CREATE TABLE " + DATABASE_TABLE + "(" +
                    KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    KEY_NAME + " TEXT NOT NULL, " +
                    KEY_AMOUNT + " INTEGER NOT NULL, " +
                    KEY_RATE + " INTEGER NOT NULL, " +
                    KEY_TIME + " INTEGER NOT NULL, " +
                    KEY_TIMEST + " created_at DATETIME DEFAULT CURRENT_TIMESTAMP);" //this way works fine