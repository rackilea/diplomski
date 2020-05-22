public Cursor fetch() 
            {
                return db.query(DATABASE_TABLE,new String[] {
                    DATE,
                    TIME
                    },                        
                        DATE + "!=''",
                        null,
                        null, 
                        null, 
                        null);                           


            }