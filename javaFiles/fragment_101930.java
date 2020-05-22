if (message.isMimeType("message/rfc822")) {
    Message message = (Message) part.getContent();
    ...
}
else if (message.isMimeType("multipart/*")) {
    Multipart mp = (Multipart) part.getContent();
    for (int i = 0, max = mp.getCount(); i < max; i++) {
        ...
    }
}
else if (message.isMimeType("text/*")) {
    String text = (String) part.getContent();
    ...
}
else {
    ...
}