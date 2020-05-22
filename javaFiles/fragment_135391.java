@Test
@PactTestFor(pactMethod = "createPact", providerType = ProviderType.ASYNCH)
public void test(MessagePact messagePact) throws Exception {
    String text = new String(messagePact.getMessages().get(0).contentsAsBytes());
    personGeloeschtConsumer.verarbeiteRecord(text);
}