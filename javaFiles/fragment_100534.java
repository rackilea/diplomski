double lat = 10.017860;
double lon = 76.342782;
Cursor c = db.rawQuery("select place from mytable where " 
        + lat + " >= CAST(sw_lat as DOUBLE) AND " 
        + lat + " <= CAST(ne_lat as DOUBLE) AND " 
        + lon + " >= CAST(sw_lon as DOUBLE) AND " 
        + lon + " <= CAST(ne_lon as DOUBLE)", null);