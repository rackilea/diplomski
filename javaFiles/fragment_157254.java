RequestQueue queue = new Volley().newRequestQueue(this);
            final JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener< JSONArray>() {
                        @Override
                        public void onResponse(JSONArray response) {
                            Gson gson = new Gson();

List<MovieModel> movieModels = gson.fromJson(response.toString(), List.class);
MovieModel movieModal = movieModels.get(0);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    });

                    queue.add(jsonArrayRequest);