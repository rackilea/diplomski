@Override
public void attach() {
    super.attach();
    Object previousSessionError = getSession().getSession().getAttribute("PrevSessionError");
    if (previousSessionError != null) {
        Notification notification = new Notification(previousSessionError.toString(), Notification.Type.ERROR_MESSAGE);
        notification.setDelayMsec(-1);
        notification.show(getUI().getPage());
        getSession().getSession().setAttribute("PrevSessionError", null);
    }
}