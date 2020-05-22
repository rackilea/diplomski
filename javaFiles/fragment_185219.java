long curretTime = System.currentTimeMillis()

Cursor cursor = mDatabase.query(
              PhysicalActivityDatabaseHelper.TABLE_NAME, //Table name
              mColumns,                                  //Queryed columns
              PhysicalActivityDatabaseHelper.TIMESTAMP + " = " currentTime, //Select
              null, null, null,
              PhysicalActivityDatabaseHelper.TIMESTAMP + " DESC" //Order By
          );