@Override
  public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    TestRow test = (TestRow)source;
    for (TestArguments arg : test.getArguments()) {
      for (ArgObject val : arg.getAllTestArguments()) {
        writer.startNode(val.getKey());
        writer.addAttribute("type", val.getType());
        writer.setValue(val.getVal());
        writer.endNode();

      }
    }
  }

  @Override
  public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
    TestArguments testargs = new TestArguments();
    while (reader.hasMoreChildren()) {
      reader.moveDown();
      String typeval = reader.getAttribute("type");
      if (typeval.isEmpty()) {
        typeval = "null";
      }
      testargs.getAllTestArguments().add(new ArgObject(reader.getNodeName(), typeval, reader.getValue()));
      reader.moveUp();
    }
    TestRow result = new TestRow(testargs);
    return result;
  }