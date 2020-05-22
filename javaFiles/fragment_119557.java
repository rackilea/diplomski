ImageMap<User> map = new ImageMap<User>();

List<User> users = ...;
for (User user : users)
{
    map.setBounds(user, user.getImage().getBounds());
}