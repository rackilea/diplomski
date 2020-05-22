@SMDMethod
public User getUser() {

    user = new User();
    user.setName("Tiny");
    user.setLocation("India");

    try {
        user.setDob(new SimpleDateFormat("dd-MMM-YYYY").parse("29-Feb-2000"));
    } catch (ParseException ex) {
        Logger.getLogger(TestAction.class.getName()).log(Level.SEVERE, null, ex);
    }

    return user;
}