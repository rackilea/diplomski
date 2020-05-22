List<Operation> operations = Arrays.asList(new Operation1(), new Operation2(), new Operation3());

for(Operation operation: operations) {
  if(!perform(operation)) {
    return;
  }
}