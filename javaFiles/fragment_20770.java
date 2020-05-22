// First, retrieve the user you want.
User user = (User) session.get(User.class, user_id_you_want);
// Second, get the contacts of that given user and add them to a list (optional)
List contacts = new ArrayList();
contacts.addAll(user.getContactSet());
return contacts;