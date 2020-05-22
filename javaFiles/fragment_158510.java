@Inject
private CardProcessor processor;

...

CreditCard card = new CreditCard(...params...);
processor.process(card);