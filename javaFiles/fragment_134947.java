ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(getActivity(), new ParseQueryAdapter.QueryFactory<ParseObject>() {public ParseQuery<ParseObject> create() {
                                  // Here we can configure a ParseQuery to our heart's desire.

                                    final ParseQuery<ParseObject> cUser = ParseQuery.getQuery("contact");


                                    ParseQuery<ParseObject> query = new ParseQuery<ParseObject>("contact");
                                    try 
                                    {
                                        query=cUser.get("MyObjectIdGoesHere").getRelation("has").getQuery();
                                    } catch (ParseException e) 
                                    {
                                        e.printStackTrace();
                                    }
                                  return query;

                                }
                              });


        adapter.setTextKey("screenName");
        setListAdapter(adapter);