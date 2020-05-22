Gson gson = new Gson();
ArrayList<Account> accountList = new ArrayList<Account>();
JSONArray accounts = data.getJSONArray("data");  
for (int i = 0; i < accounts.length(); i++) {
  JSONObject a = accounts.getJSONObject(i).getJSONObject("data");
  accountList.add(gson.fromJson(a.toString(), Account.class));
}