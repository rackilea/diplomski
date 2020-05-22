JSONArray jsonArray = jsonObject.getJSONArray("results");


                for (int i = 0; i < jsonArray.length(); i++) {

                    JSONObject js = jsonArray.getJSONObject(i);
                    MovieItem item = new MovieItem();
                    item.setMovieTitle(js.getString("poster_path"));
                    list.add(item);}