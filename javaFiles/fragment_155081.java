if(mCursor!=null){
if (mCursor.moveToFirst()) {
                do {
                    name = (mCursor.getString(mCursor.getColumnIndex("name")));
                    description =(mCursor.getString(mCursor.getColumnIndex("description")));
                    nutrition=(mCursor.getString(mCursor.getColumnIndex("nutrition")));
                    allergen=(mCursor.getString(mCursor.getColumnIndex("allergen")));
                    mainimage=(mCursor.getString(mCursor.getColumnIndex("image")));
                } while (mCursor.moveToNext());
            }

}