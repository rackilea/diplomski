if (cursor !=null && cursor.getCount() > 0)
    {
        cursor.moveToFirst();
        RReckoner_info rReckoner_info = new RReckoner_info(cursor.getString(0),cursor.getString(1),Integer.parseInt(cursor.getString(2)),
            cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6)
            ,cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),
            cursor.getString(11),cursor.getString(12),cursor.getString(13),cursor.getString(14),
            Integer.parseInt(cursor.getString(15)),cursor.getString(16),cursor.getString(17));

    return rReckoner_info;
    }
return null;