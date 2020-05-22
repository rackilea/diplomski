...
final Form<Contact> contactForm;
if (currentUser.isAdministrator()) {
    contactForm = form(Contact.class, Administrator.class).bindFromRequest();
} else {
    contactForm = form(Contact.class, User.class).bindFromRequest();
}
...