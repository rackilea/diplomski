String searchParams = searchText.getText().toString().trim();

                if(!searchParams.isEmpty()) {
                    final ArrayList<SearchResults> searchResults = new ArrayList<SearchResults>();
                    listAdapter = new ListAdapter(activityContext, searchResults);
                    listView.setAdapter(listAdapter);

                    ParseQuery<ParseUser> queryName = ParseUser.getQuery();
                    queryName.whereContains("name", searchParams);
                    ParseQuery<ParseUser> queryPhone = ParseUser.getQuery();
                    queryPhone.whereContains("username", searchParams);
                    ParseQuery<ParseUser> queryEmail = ParseUser.getQuery();
                    queryEmail.whereContains("email", searchParams);
                    ParseQuery<ParseUser> querySurname1 = ParseUser.getQuery();
                    querySurname1.whereContains("surname1", searchParams);
                    ParseQuery<ParseUser> querySurname2 = ParseUser.getQuery();
                    querySurname2.whereContains("surname2", searchParams);

                    List<ParseQuery<ParseUser>> queries = new ArrayList<ParseQuery<ParseUser>>();
                    queries.add(queryName);
                    queries.add(queryPhone);
                    queries.add(queryEmail);
                    queries.add(querySurname1);
                    queries.add(querySurname2);

                    ParseQuery<ParseUser> mainQuery = ParseQuery.or(queries);

                    mainQuery.findInBackground(new FindCallback<ParseUser>() {
                        @Override
                        public void done(List<ParseUser> objects, ParseException e) {
                            if (e == null)
                            {
                                Log.d("Brand", "Retrieved " + objects.size() + " Brands");
                                for (ParseObject dealsObject : objects) {
                                    Log.i("USERNAME", dealsObject.getString("name"));
                                    Log.i("PRIVATE", Integer.toString(dealsObject.getInt("private")));
                                    SearchResults sr1 = new SearchResults();
                                    sr1.setName(dealsObject.getString("name"));
                                    sr1.setSurname1(dealsObject.getString("surname1"));
                                    sr1.setSurname2(dealsObject.getString("surname2"));
                                    sr1.setUid(dealsObject.getObjectId());
                                    Log.d("UID",dealsObject.getObjectId());

                                    if(dealsObject.getInt("private") == 0)
                                    {
                                        sr1.setEmail(dealsObject.getString("email"));
                                        sr1.setPhone(dealsObject.getString("username"));
                                    }
                                    else
                                    {
                                        sr1.setPhone("xxx-xxx-xxx");
                                        sr1.setEmail("xxxxxx@xxxxx.xxx");
                                    }

                                    searchResults.add(sr1);
                                }
                            } else {
                                Log.d("Brand", "Error: " + e.getMessage());
                            }

                            listAdapter.notifyDataSetChanged();