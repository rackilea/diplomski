public void unattend(Event e, User u){
    // mandatory:
    e.getUsers().remove(u);
    // optional:
    u.getEvents().remove(e);
}