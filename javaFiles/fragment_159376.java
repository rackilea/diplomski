public Interface Operation {
   // don't necessarily need state
   public void calculate (Element e, State state);
}

CountOp extends Operation {
   count = 0;

   public void calculate(Element e, State state){
      // not using element or state because this is so simple....
      count++;
   }
}

Operation op = new CountOp();
State state = new SomeStateImpl();
for (File f : directory()) {
    for (Element e : listWeSomehowGetFromTheFile) {
          op.calculate(e, state);
    }
}