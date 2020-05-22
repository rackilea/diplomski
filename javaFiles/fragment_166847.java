//List of mails in db.
ArrayList<String> emailsInDB = getAllMailsFromDB(user);

//Iterates all emails gotten from the form.
for (String email : emailsInForm) {
  if (!emailsInDB.contains(email) {
    //New mail! Add it in the db!
    db.insertMail(email, user);
}