if (cur != null ) {
    if  (cur.moveToFirst()) {
        do {
            String tmp = c.getString(R.string.naam)
            ...
        }while (cur.moveToNext());
    }
}