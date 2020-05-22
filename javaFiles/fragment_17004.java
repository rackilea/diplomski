do {
        String word = cursor.getString(cursor.getColumnIndexOrThrow("word"));

        // Unsure about this line, change it as needed:
        int id = cursor.getInt(cursor.getColumnIndexOrThrow("_id")); 

        wordsToIdMap.put(word, id);
    } while(cursor.moveToNext());