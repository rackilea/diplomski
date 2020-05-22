void add(Diary diary){

if (mEntriesToday.getValue() != null) {        
    Log.e(TAG, "add: with matching entries"+ mEntriesToday.getValue().get(0) + " add: " +  diary );
    mEntriesToday.getValue().get(0).addAttributes(diary);
    new updateDiaryAsyncTask(mDiaryDao).execute(mEntriesToday.getValue().get(0));
} else {
   Log.e(TAG, "add: without matching entries"+" add: " +  diary );
   new insertDiaryAsyncTask(mDiaryDao).execute(diary);
    }
}