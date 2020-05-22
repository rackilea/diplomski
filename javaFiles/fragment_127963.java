Map<String, Object> responseObj = new HashMap<String, Object>();
List<User> userList = new ArrayList<User>();
userList.add(new User(1, 1));
userList.add(new User(2, 2));
responseObj.put("canApprove", true); //1
responseObj.put("approvers", userList);

System.out.println(new JSONObject(responseObj));