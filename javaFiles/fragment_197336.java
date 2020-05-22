private void parseMovieJSON(String url) {

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {


                        try {
                            JSONArray jsonArray = response.getJSONArray("results");

                            myMoviesList.clear()

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject movie = jsonArray.getJSONObject(i);

                                //Get json data as strings
                                String posterPath = movie.optString("poster_path");
                                String originalTitle = movie.optString("title");
                                String overview = movie.getString("overview");
                                String releaseDate = movie.optString("release_date");
                                String voteAverage = movie.optString("vote_average");


                                mMoviesList.add(new Movies(posterPath, originalTitle, overview, releaseDate, voteAverage));

                            }

                            myMoviesAdapter.notifyDataSetChanged()



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (volleyError instanceof NetworkError) {

                    if (checkConnection()) {

                        parseMovieJSON();

                    } else if (!checkConnection()) {

                        Toast.makeText(MainActivity.this, "Check Network Connection", Toast.LENGTH_SHORT).show();
                        mMoviesList = null;

                    }


                }

            }
        });

        mRequestQueue.add(request);
        checkConnection();

    }