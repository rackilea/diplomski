public class User implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        Set<User> logins = (Set<User>) event.getSession().getServletContext().getAttribute("logins");
        logins.add(this);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        Set<User> logins = (Set<User>) event.getSession().getServletContext().getAttribute("logins");
        logins.remove(this);
    }

    // @Override equals() and hashCode() as well!

}