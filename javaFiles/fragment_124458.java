cursor.moveToFirst();
do {
    if (queryValues.get("whichPlayer").equals(whichPlayer)) {
       // ...
    }
} while (cursor.moveToFirst());