// using new to ensure unique identity
private static final String EOF = new String("end of file");

…
new SourceFileProducer(queue, EOF, …)
new SourceFileConsumer(queue, EOF, …)