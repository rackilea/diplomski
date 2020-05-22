Collections.sort(channelsList, new Comparator<Channel>() {
    DateFormat format = new SimpleDateFormat(DATE_FORMAT_PATTERN);

    @Override
    public int compare(Channel o1, Channel o2) {
        // If both are null, they are equal
        if (o1.getConversation() == null && o2.getConversation() == null)
            return 0;

        // If only first one is null, it is less than the other (null's come first)
        if (o1.getConversation() == null)
            return -1;

        // If only second one is null, it is greater than the other
        if (o2.getConversation() == null)
            return 1;

        Conversation c1 = o1.getConversation();
        Conversation c2 = o2.getConversation();

        // Same comparisons are done here again
        if (c1.getSentAt() == null && c2.getSentAt() == null)
            return 0;

        if (c1.getSentAt() == null)
            return -1;

        if (c2.getSentAt() == null)
            return 1;

        try {
            if (Util.isUTCFormat(o1.getConversation().getSentAt()) && Util.isUTCFormat(o2.getConversation().getSentAt()))
                return format.parse(o1.getConversation().getSentAt()).compareTo(format.parse(o2.getConversation().getSentAt()));
            else
                return -1;

        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }              
    }
});