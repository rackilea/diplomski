for (int i = 0; i < response.length(); i++) {

                                JSONObject person = (JSONObject) response
                                        .get(i);
                                items.add(person.getString("name"));
                            Toast.makeText(getApplicationContext(),
                                    person.getString("name"),
                                    Toast.LENGTH_LONG).show();
                        }
                       adapter.notifyDataSetChanged();