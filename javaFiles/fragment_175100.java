public static void userUpdate(String apikey, JsonObject body) {
    Long idUser = decode(apikey);
    User oldUser= User.findById(idUser);

    Map<String, User> userMap = new HashMap<String, User>();
    Type arrayListType = new TypeToken<Map<String, User>>(){}.getType();
    userMap = gson().fromJson(body, arrayListType);
    User user = userMap.get("user");

oldUser.em().merge(user);

oldUser.save();
}