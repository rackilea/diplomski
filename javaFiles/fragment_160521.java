Cursor cursor = ...;

if (cursor.moveToFirst()) {
  // create user from cursor data
} else {
  // create default user
}
return user;