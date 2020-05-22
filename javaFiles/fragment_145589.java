public void write(TProtocol oprot, TUnion struct) throws TException {
  if (struct.getSetField() == null || struct.getFieldValue() == null) {
    throw new TProtocolException("Cannot write a TUnion with no set value!");
  }

  // ... more code ...
}