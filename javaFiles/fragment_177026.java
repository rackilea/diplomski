GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object,
                                            GraphResponse response) {

                        userId = object.optString("id");
                        Log.d("id", userId); 
        db.execSQL("INSERT INTO Information (userId) VALUES ('" + userId +"');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('First exercise', 'Exercise', '10');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Stronger', 'Exercise', '50');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Body builder', 'Exercise', '100');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('First check-in', 'Check-in', '1');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Go around', 'Check-in', '10');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Become tourist', 'Check-in', '50');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Traveller', 'Check-in','100');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Wait! Is this the same place?', 'Check-in', '1');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('First time here', 'Todo', '1');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('So busy', 'Todo', '10');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Business man', 'Todo', '50');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('What todo first', 'Todo', '100');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('First times Saving', 'Saving', '1');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Money kids style', 'Saving', '10');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Way to rich', 'Saving', '200');");
        db.execSQL("INSERT INTO Achievement (AName, AType, AScore) VALUES ('Rich boy', 'Saving', '2000');");
        db.close();
        data.close();
        loginState();
                    }
                });
        request.executeAsync();