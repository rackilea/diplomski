List<String> myList = new ArrayList<>();
//add elements in myList object

String jsonFormat = gson.toJson(myList,listType);  
//adding to sharedPref  
editor.put("list",jsonFormat).apply();