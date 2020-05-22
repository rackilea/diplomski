//Get user
User user = getPersistUser(context);

//Change
user.setCoverImage(true)

//Save
persistUser(context, user)