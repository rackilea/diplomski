query.getFirstInBackground(new GetCallback<ParseObject>() {

               @Override
               public void done(ParseObject gameInfo, ParseException e) {
                    if (e == null) {
                         Log.d(TAG, "success!");

                         mSavedWordList = gameInfo.getString(ParseConstants.KEY_SELECTED_WORDS);
                         Gson gson = new Gson();
                         Type type = new TypeToken<ArrayList<String>>() {
                            }.getType();
                         ArrayList<String> finalWordList = gson.fromJson(mSavedWordList, type);
                         mCopy.addAll(finalWordList);
                         /* mCopy is updated here - so use it now*/
                         word1 = (TextView) findViewById(R.id.word1); 
                         word1.setText(mCopy.get(1));
                         word1.setOnClickListener(new View.OnClickListener());


    });