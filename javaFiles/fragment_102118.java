Cursor data = mdatabaseHelper.getData();
                                if (data != null) {
       listRec=new ArrayList(ModelAccounts); // create new instance or clear existing list

                                    while (data.moveToNext()) {
                                        listRec.add(new ModelAccounts(data.getString(1), data.getString(3)));
                                        Log.d(TAG, "ADDING " + data.getString(1) + " to ARRAY");
                                    }
                                    customAdapter = new AccountsAdapter(getApplicationContext(), listRec);
                                    customAdapter.notifyDataSetChanged();
                                    listView.setAdapter(customAdapter);
                                } else {
                                    Toast.makeText(AccountsActivity.this, "Create a new account", Toast.LENGTH_SHORT).show();
                                }