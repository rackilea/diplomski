Query q = em
    .createQuery("SELECT u FROM " + User.class.getName()
    + "u WHERE username = :username AND password = MD5(:password)")
    .setParameter("username", txtLogin.getText())
    .setParameter("password", passPassword.getPassword())
    ;