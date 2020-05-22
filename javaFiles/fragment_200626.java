public int efficientGetContents(IMAPFolder inbox, Message[] messages)
        throws MessagingException {
    FetchProfile fp = new FetchProfile();
    fp.add(FetchProfile.Item.FLAGS);
    fp.add(FetchProfile.Item.ENVELOPE);
    inbox.fetch(messages, fp);
    int index = 0;
    int nbMessages = messages.length;
    final int maxDoc = 5000;
    final long maxSize = 100000000; // 100Mo

    // Message numbers limit to fetch
    int start;
    int end;

    while (index < nbMessages) {
        start = messages[index].getMessageNumber();
        int docs = 0;
        int totalSize = 0;
        boolean noskip = true; // There are no jumps in the message numbers
                                           // list
        boolean notend = true;
        // Until we reach one of the limits
        while (docs < maxDoc && totalSize < maxSize && noskip && notend) {
            docs++;
            totalSize += messages[index].getSize();
            index++;
            if (notend = (index < nbMessages)) {
                noskip = (messages[index - 1].getMessageNumber() + 1 == messages[index]
                        .getMessageNumber());
            }
        }

        end = messages[index - 1].getMessageNumber();
        inbox.doCommand(new CustomProtocolCommand(start, end));

        System.out.println("Fetching contents for " + start + ":" + end);
        System.out.println("Size fetched = " + (totalSize / 1000000)
                + " Mo");

    }

    return nbMessages;
}