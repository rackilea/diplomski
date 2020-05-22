//more to the first row
 c.moveToFirst();

//iterate over rows
 for (int i = 0; i < c.getCount(); i++) {

    // get all data here from current row..

    //move to the next row
    c.moveToNext();
 }
//close the cursor
c.close();