dbHelper= new DatabaseHelper(ActountActivity.this);
db = dbHelper.getWritableDatabase();
ContentValues insertValues = new ContentValues();
insertValues.put("_id", "User_Id");
insertValues.put("userGOAL", "User_Goal");
insertValues.put("userName", "User_Name");
insertValues.put("userEmail", "User_Email");
insertValues.put("userDOB", "User_DOB");
insertValues.put("userHeight", "User_Height");
insertValues.put("userWeight", "User_Weight");
insertValues.put("userGender", "User_Gender");
insertValues.put("userZIP", "User_Zip");

db.insert("UserInfo", null, insertValues);
db.close();