c.moveToFirst(); 
       while(!c.isAfterLast()) {
            deleteRow(c.getLong((int) id));
           c.moveToNext();
        } 
    }