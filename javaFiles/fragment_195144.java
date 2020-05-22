for (int j = 0; j < js.length(); j++) {

    HashMap<String, Object> hash_addd = new HashMap<>();
    hash_addd.put("image"+j, js.getString(j));
    Log.e("image"+j,":"+js.getString(j));

 }