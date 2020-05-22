mCommentList = new ArrayList<HashMap<String, String>>();


            try {

                // Building Parameters
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                params.add(new BasicNameValuePair("query", searchbox.getText().toString()));


                Log.d("request!", "starting Search");
                // getting product details by making HTTP request
                JSONObject json = jsonParser.makeHttpRequest(SEARCH_URL, "POST",
                        params);

                 AssertNotNull(json); //for asserting 

                 // To prevent the code form breaking 
                // check your log for json response
               if(json.toString().isEmpty())
                {
                   Log.d("Search Attempt", json.toString());
               }

               else{
                   search = new SEARCH();
                    search.cancel(true);



                }

                Log.d("Search Attempt", json.toString());