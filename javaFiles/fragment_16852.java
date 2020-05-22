String jsonArr = "[\"http://www.ebuy.al/Images/dsc/17470_500_400.jpg\", 
                   \"http://www.ebuy.al/Images/dsc/17471_500_400.jpg\"]";
List<String> listFromJsonArray = new ArrayList<String>();
JSONArray jsonArray = new JSONArray(jsonArr);
for(int i =0 ;i<jsonArray.length();i++){
      listFromJsonArray.add(jsonArray.get(i).toString());
}