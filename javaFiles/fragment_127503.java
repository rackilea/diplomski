MessageComparator messageComparator = new MessageComparator();
SortedSet<Message> allMessages = new TreeSet<>(messageComparator);

public List<Message> getMessagesInRange(final Date fromDate, final Date toDate, final List<Message> conversation) {
    return new ArrayList<Message>(allMessages.subSet(
        messageComparator.minFrom(fromDate), true,  messageComparator.maxFrom(toDate), true).values());
}