$("html").bind("click", new com.google.gwt.query.client.Function() {
    @Override
    public boolean f(com.google.gwt.user.client.Event e) {
        // you can check it using instanceof operator, object references or Element ID
        // e.getSource() instanceof MenuItem
        // ((Widget) e.getSource()).getElement().getId()
        if (e.getSource() != dashboardLink) {
            GwtTour.endTour(false);
            return true;
        } else {
            return false;
        }
    }
});