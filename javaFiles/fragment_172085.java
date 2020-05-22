String json = [["username1","name1"],["username2","name2"],["username3","name3"], ...]
List<User> userList = new ArrayList<>();
JSONArray array = new JSONArray(json);
int count = array.length();
for(int i = 0; i < count; i++) {
    JSONArray innerArray = array.getJSONArray(i);
    User user = new User();
    user.setUsername(innerArray[0]);
    user.setName(innerArray[1]);
    userList.add(user);
}