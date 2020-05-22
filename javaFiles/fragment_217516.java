Uri subItems = Uri.parse("content://tod.dosetracker.provider.Food");
  Cursor c = getContentResolver().query(
            CONTENT_URI_ITEMS, 
            null, 
            "_itemid = " + _id, 
            null, 
            null);