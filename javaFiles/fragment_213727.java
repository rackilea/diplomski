//---deletes a particular pub---
     public boolean deletePub(String Pub_Name) 
     {
        //delete statement. If any rows deleted (i.e. >0), returns true
        return db.delete(DATABASE_TABLE, "Pub_Name = '"+ KEY_PUBNAME+"' ", null) > 0;
        //return db.delete(DB_TABLE, "name='"+ name+"'", null) > 0;
     }