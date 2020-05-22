if (jsonObject.toString().contains(Constant.JSON_KEY.RESPONSE)) {
                        JSONObject response = jsonObject.getJSONObject(Constant.JSON_KEY.RESPONSE);

                        String userId = response.getString(Constant.JSON_KEY.ID);
                        String fname = response.getString(Constant.JSON_KEY.FNAME);
                        String lname = response.getString(Constant.JSON_KEY.LNAME);
                        String phone = response.getString(Constant.JSON_KEY.PHONE);

                        SignUpDetailsClass signUpDetailsClass = new SignUpDetailsClass();
                        signUpDetailsClass.setId(userId);
                        signUpDetailsClass.setFname(fname);
                        signUpDetailsClass.setLname(lname);
                        signUpDetailsClass.setPhone(phone); 

                        **// store data in sharedPreference**
                        AppPreference.setStringPref(context, AppPreference.PREF_USERID, AppPreference.PREF_KEY.USERID, userId);
                        AppPreference.setStringPref(context, AppPreference.PREF_FNAME, AppPreference.PREF_KEY.FNAME, fname);
                        AppPreference.setStringPref(context, AppPreference.PREF_LNAME, AppPreference.PREF_KEY.LNAME, lname);
                        AppPreference.setStringPref(context, AppPreference.PREF_PHONE, AppPreference.PREF_KEY.PHONE, phone);
    }