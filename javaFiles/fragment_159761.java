public void messages(int page) {
    User connectedUser = User.find("byEmail", connected());
    List<Message> messages = Message.find(
        "user = ? and read = false order by date desc",
        connectedUser
    ).from(page * 10).fetch(10);
    render(connectedUser, messages);
}