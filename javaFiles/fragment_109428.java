final String[] design = new String[1];

private MobileServiceTable<User> mUser;

mUser = mClient.getTable(User.class);

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... params) {
                    try {
                        final MobileServiceList<User> result =
                                mUser.where().field("name").eq(x).execute().get();
                        for (User item : result) {
                           // Log.i(TAG, "Read object with ID " + item.id);
                            desig[0] = item.getDesignation(); //getDesignation() is a function in User class ie- they are getters and setters
                            Log.v("FINALLY DESIGNATION IS", desig[0]);

                        }

                    } catch (Exception exception) {
                       exception.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    super.onPostExecute(aVoid);
                    designation.setText(desig[0]);
                }
            }.execute();