public long getNext(int id,DataBaseHelper helper){

            id = id - 1;        

    Story story = new Story();

    Cursor cursor = story.getStories(helper, 0);

            //Updated code      

    cursor.moveToPosition(id);

    cursor.moveToNext();

    return cursor.getLong(1);

            //Updated code

}