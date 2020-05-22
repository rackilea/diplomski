public static void saveWords(AppCompatActivity appCompatActivity, Context context, JSONArray response) {
        DbHelper helper = new DbHelper(context);


        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("Finalising...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        db = helper.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues contentValues = new ContentValues();
            for (int i = 0; i < response.length(); i++) {
                JSONObject object = response.getJSONObject(i);
                String wordId = object.getString("wordid");
                String category = object.getString("category");
                String word = object.getString("word");
                String meaning = object.getString("meaning");
                String letter = object.getString("letter");

                String[] columns = {DbConstants.WORD_ID};
                String whereClause = DbConstants.WORD_ID + " = ? ";
                String whereArgs[] = {wordId};

                Cursor cursor = db.query(DbConstants.TABLE_WORDS, columns, whereClause, whereArgs, null, null, null, null);
                if (cursor.getCount() <= 0) {
                    contentValues.put(DbConstants.WORD_ID, wordId);
                    contentValues.put(DbConstants.CATEGORY, category);
                    contentValues.put(DbConstants.WORD, word);
                    contentValues.put(DbConstants.MEANING, meaning);
                    contentValues.put(DbConstants.LETTER, letter);
                    contentValues.put(DbConstants.STATUS, "0");

                    db.insert(DbConstants.TABLE_WORDS, null, contentValues);

                }
                cursor.close();
            }
            db.setTransactionSuccessful();

        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            progressDialog.dismiss();
            appCompatActivity.recreate();
        }


        }
    }