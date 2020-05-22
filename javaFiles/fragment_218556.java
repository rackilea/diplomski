mSCA.setViewBinder(new SimpleCursorAdapter.ViewBinder(){
   /** Binds the Cursor column defined by the specified index to the specified view */
   public boolean setViewValue(View view, Cursor cursor, int columnIndex){
       if(view.getId() == R.id.your_image_view_id){
           String yourImageNameFromDb = cursor.getString(2);
           int resID = getResources().getIdentifier(yourImageNameFromDb , "drawable", getPackageName());

          ((ImageView)view).setImageDrawable(getResources().getDrawable(resID));
           return true; //true because the data was bound to the view
       }
       return false;
   }
});