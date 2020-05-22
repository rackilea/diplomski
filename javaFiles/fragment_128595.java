public void feed(List<Signal> inSigs) {
  // Needs precondition that inSigs.size() == input.size()
  for (int i = 0; i < inSigs.size(); i++) {
    inputs.get(i).setSignal(inSigs.get(i));
  }
}