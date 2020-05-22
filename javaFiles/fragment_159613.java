//Creation de la table
        @Override
        public void onCreate(SQLiteDatabase db) {
            //requet de création
            String ReqCrea = "CREATE TABLE "+AndroidProvider.CONTENT_PROVIDER_DB_NAME+" ("+Cours.COURS_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +Cours.COURS_NAME+ " VARCHAR(255),"+Cours.COURS_DESC+" VARCHAR(255)"+");";
            //Execution de la requete avec le param db
            db.execSQL(ReqCrea);
        }