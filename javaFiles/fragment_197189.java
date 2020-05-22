public static void transactional2() {
    com.avaje.ebean.Ebean.beginTransaction();

    User user = User.query.getById(22l);
    user.setPassword("qweqwe123");
    user.save();

    com.avaje.ebean.Ebean.rollbackTransaction();
    // OR: com.avaje.ebean.Ebean.commitTransaction();
}