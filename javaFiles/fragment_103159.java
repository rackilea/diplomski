public T pop() {
  if (lastAdded.empty()) {
    throw Exception();
  }
  int lastColor = lastAdded.pop();
  if (lastColor == 0) {
    return redStack.pop();
  }
  return blueStack.pop();
}