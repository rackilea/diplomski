RelatedResults results = t.getRelatedResults(tweetId);
List<Status> conversations = results.getTweetsWithConversation();
/////////
Status originalStatus = t.showStatus(tweetId);
if (conversations.isEmpty()) {
    conversations = results.getTweetsWithReply();
}

if (conversations.isEmpty()) {
    conversations = new ArrayList<Status>();
    Status status = originalStatus;
    while (status.getInReplyToStatusId() > 0) {
        status = t.showStatus(status.getInReplyToStatusId());
        conversations.add(status);
    }
}
// show the current message in the conversation, if there's such
if (!conversations.isEmpty()) {
    conversations.add(originalStatus);
}