ParseQuery<ParseObject> query=ParseQuery.getQuery("GameScore");
        query.getInBackground("YsHLfJ7tUB", new GetCallback<ParseObject>() {

            @Override
            public void done(ParseObject arg0, ParseException arg1) {
                // TODO Auto-generated method stub

                if (arg1==null)
                {
                    int score = arg0.getInt("score");
                    playerName = arg0.getString("playerName");
                    boolean cheatMode = arg0.getBoolean("cheatMode");
                    tv.setText("Updating "+playerName);

                }
                else
                {
                    Log.d("score", "Error: " + arg1.getMessage());
                }
            }