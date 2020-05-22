public class User {

  public User() {
    name = "";
    friends = new ArrayList<User>();
  }

  /** Create a User from a JSON Object **/
  public static User createFromJson(JSONObject json) {
    User u = new User();

    // Read simple fields of the JSON object
    u.name = json.optString("name");

    // Now recursively read other users from a "friend" property
    JSONArray jsonFriends = json.optJSONArray("friends");
    for (int i=0; i<jsonFriends.length(); ++i) {
      // This is the next nested JSON Object
      JSONObject jsonFriend = jsonFriends.getJSONObject(i);

      // We convert it to a Java object
      User friend = User.createFromJson(jsonFriend);

      // And add it to our friend list
      u.friends.add(friend);
    }
  }

  private String name;
  private List<User> friends;
}