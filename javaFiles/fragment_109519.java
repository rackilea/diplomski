ArrayList<Item> items = new ArrayList<>();
    Cursor cursor = //make a call to database
    if (cursor.moveToFirst()) {
        Item item;
        for (int i = 0; i < cursor.getCount(); i++) {
            item = new Item();
            item.setName("read data from cursor and add it here"); 
            item.setMeasurment("read data from cursor and add it here"); 
            item.setUnit("read data from cursor and add it here"); 
            myModels.add(item);
            if (!cursor.moveToNext()) {
                break;
            }
        }
    }