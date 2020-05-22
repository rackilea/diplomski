public void add(User user) {

    LOGGER.debug("Adding new user");
    Session session = sessionFactory.getCurrentSession();
    Actions actions = new Actions();
    actions.setActionType(ActionType.ADDING_NEW_USER);
    actions.setDate(new Date());
    user.addActions(actions);
    session.save(user);
}