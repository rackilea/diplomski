List<Map> getAllChild(int parent_id, int depth) {

 // check whether maximum depth is reached
 if (depth == 0) {
   return Collections.EMPTY_LIST;
 }
 depth--;

 int count = 0, user_id = 0;
 List listChild = runSQL("SELECT user_id FROM parent_user WHERE parent_id = "+parent_id);
 List<Map> subList;
 for (int i = 0; i < listChild.size(); i++) {
  user_id = listChild.get(i));
  Map userProfile = runSQL("SELECT * FROM user_profile WHERE user_id = "+user_id);
  subList.add(userProfile);
  subList.addAll(getAllChild(user_id, depth));
 }
 return subList;
}