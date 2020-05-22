Vector users = dbHelper.getAll();
for (int i = 0; i < users.size(); i++) {
    User user = (User) users.elementAt(i);
    user.getUsername();
    user.getFullName();
}