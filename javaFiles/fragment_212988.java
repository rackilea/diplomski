public ZKTripSessionManager implements TripSessionManager {

    public void setTo(String to) {
        setAttribute("to", to);
    }

    public void setFrom(String from) {
        setAttribute("from", from);
    }

    private void setAttribute(String name, String value) {
        // only valid if called in a ZK managed thread
        Sessions.getCurrent().setAttribute(name, value);
    }

}