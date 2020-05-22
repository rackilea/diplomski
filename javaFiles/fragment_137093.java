public List<CategoryClass> getAllCategory()
{
      List<CategoryClass> getCategoryList = new ArrayList<CategoryClass>();
      dataAdapter = dataAdapter.openToWrite();
      Cursor cursor = db.rawQuery("SELECT * FROM " + tb_Name,null);
      if(cursor!=null){
             cursor.moveToFirst(); 
             while(!cursor.isAfterLast()){
                 CategoryClass categoryInstance = new CategoryClass();
                 categoryInstance.setCategory(cursor.getString(1));

            // Adding contact to list
                 getCategoryList.add(categoryInstance);

                 cursor.moveToNext();
              }
           }

       Log.d("retrieving all categories","count < 0");

       return getCategoryList;
 }