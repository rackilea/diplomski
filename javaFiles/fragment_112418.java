String url = 'https://project-name.firebaseio.com/users/user1/email'

//Initialize database
Firebase firebase = new Firebase(baseUrl);

//remove email of user1
Map<String, Object> dataMap = new LinkedHashMap<String, Object>();
dataMap.put("some str", null);
firebase.put(dataMap)