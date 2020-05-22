public List<Message> splitMessage(Exhange exchange) {
    List<Message> answer = new ArrayList<Message>();
    File inputFile = exchange.getIn().getBody(File.class);
    List<YourObject> parts = yourSplittingOfTheFile(inputFile);
    for (YourObject part : parts) {
        DefaultMessage message = new DefaultMessage();
        message.setBody(body);
        answer.add(message);
    }
    return answer;
}