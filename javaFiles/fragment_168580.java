JSONObject object = new JSONObject(result);
                    ^^^^^^^^^^^^^^^^^^^^^^
                    the content of result is not an object, but an array!

JSONArray jsonArray = object.getJSONArray("");
                                          ^^
                                          a proper JSON document had better not have empty keys!

//JSONArray jsonArray = new JSONArray(result);
                        ^^^^^^^^^^^^^^^^^^^^^
                        this was actually going in the right direction!

for (int i = 0; i < jsonArray.length(); i++) {
    JSONObject c = jsonArray.getJSONObject(i);
                   ^^^^^^^^^^^^^^^^^^^^^^^^^^
                   the i-th element of the array is not an object, but an array!