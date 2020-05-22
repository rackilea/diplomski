cursor.moveToFirst()
 while (cursor.isAfterLast()){
            String id = Integer.toString(cursor.getInt(0));
            String date = cursor.getString(1);
            String minutes = Integer.toString(cursor.getInt(2));
            String finalValue = id + "|" + date + "|" + minutes;
            arrayList.add(finalValue);
        }