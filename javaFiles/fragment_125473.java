private void makeJsonObjectRequest(int startList, int endList, JsonObjectListener listener) {
            JsonArrayRequest movieReq = new JsonArrayRequest(url,
                    new Response.Listener<JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Log.d(TAG, response.toString());
                            i = startLsit;
                            while(i < endList) {
                                try {
                                    JSONObject obj = response.getJSONObject(i);
                                    Movie movie = new Movie();

                                  /***** TONS OF CODE  *****/

                                        movieList.add(movie);
                                    }

                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();

                                }
                              i++;
                              lastNumber = i;
                            }
                            mAdapter.notifyDataSetChanged();
                            if(listener!=null)
                                listener.onDone(lastNumber);
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                       if (listener != null)
                            listener.onError(error.getMessage());
                }
            });
            AppController.getInstance().addToRequestQueue(movieReq);

        }