XMPPConnection connection = …;
connection.addSyncStanzaListener(new StanzaListener() {

@Override
void process(Stanza stanza) {
    Message message = (Message) stanza;
    // Received new message with body from user@example.org
}, new AndFilter(MessageWithBodiesFilter.INSTANCE, 
    FromMatchesFilter.create("user@example.org")));