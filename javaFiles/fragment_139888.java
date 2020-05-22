private final Class<INTERACTION> interactionType;
private final Class<INVOCATION> invocationType;
private final Constructor<INTERACTION> interactionConstructor;

public AbstractInitializer(final Class<INTERACTION> interactionType,
    final Class<INVOCATION> invocationType) throws NoSuchMethodException {
  this.interactionType = interactionType;
  this.invocationType = invocationType;
  interactionConstructor = interactionType.getConstructor(invocationType);
}

public INTERACTION handle(Message message) throws IOException, MessageException,
        InvocationTargetException, InstantiationException, IllegalAccessException {
  checkMessageIsNotNull(message);
  INVOCATION invocation = construct(message.getBody().toString());
  l.debug("handling in initializer...  {}", invocation);
  return interactionConstructor.newInstance(invocation);
}

public INVOCATION construct(String message) throws IOException, MessageException {
  ObjectMapper mapper = new ObjectMapper();
  INVOCATION invocation;
  try {
    invocation = mapper.readValue(message, invocationType);
  } catch (IOException e) {
    throw new MessageException("Can't deserialize message", e);
  }
  return invocation;
}