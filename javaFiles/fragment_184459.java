public void parseMessage(Object message) { // changed to Object
  ...
  ...
  if (message instanceof String)
    parser.parse((String) message);
  else {
    if (message instanceof MessageObject) {
      if (!(parser instanceof MessageObjectParser)) {
        throw new IllegalArgumentException(
          "A MessageObject is passed, but not supported by the parser");
      }
      ((MessageObjectParser) parser).parse((MessageObject) message);
    } else {
      throw new IllegalArgumentException(
        "Messages of type " + parser.getClass() + " aren't supported");
    }
  }
}