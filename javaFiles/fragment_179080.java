private Manager manager(HttpSession session) throws Exception {

    Field facadeSessionField = StandardSessionFacade.class.getDeclaredField("session");
    facadeSessionField.setAccessible(true);
    StandardSession stdSession = (StandardSession) facadeSessionField.get(session);

    return stdSession.getManager();
}