public Cursor fetch() 
        {
            return db.query(DATABASE_TABLE,
                    null, 
                    DATE + "!=''",
                    null,
                    null, 
                    null, 
                    null);                        


        }