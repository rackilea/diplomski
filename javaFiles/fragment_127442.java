while (true) {
  Object[] objs = new Object[S];
  for (int i = 0; i < S; ++i) {
    objs[i] = queue.take();  // Perhaps with a timeout?
  }
  doSomethingWithObjects(objs);
}