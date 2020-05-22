public static void editUser(User user) {
   JPA.em().detach(user); // detach framework managed user object
   User old = User.findById(user.id); // get old value from database (get original data)

   // in this scope, "old" variable has same value as in database
   ...

   user = JPA.em().merge(user); // tell framework to manage user object again and reassign variable reference
   user.save(); // persist change to database
}