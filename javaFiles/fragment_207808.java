protected void addMessage(String key, boolean isError,
        HttpServletRequest request, Object... args) {
    List<Message> msgs = (List<Message>) request.getAttribute(MESSAGES_KEY);
    if (msgs == null) {
        msgs = new LinkedList<Message>();
    }

    Message msg = new Message();
    msg.setMessage(msg(key, args));
    msg.setError(isError);
    msgs.add(msg);
    request.setAttribute(MESSAGES_KEY, msgs);
}