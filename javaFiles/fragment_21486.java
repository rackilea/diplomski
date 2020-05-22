public String getActionCode(int id) {

    //ApplicationContext context;

    Session  session = getSessionFactory().getCurrentSession();
    Actioncode actionCode=null;
    actionCode = (Actioncode)session.get(Actioncode.class, 1);

    return actionCode.getActionName();
}