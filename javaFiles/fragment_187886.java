List<Out> list = new ArrayList<>();
for (B b : a.parB) {
  for (C c : b.parE) {
    list.add(new Out(a.parA, b.parC, b.parD, c.parF, c.parG, c.parH, c.parJ));
  }
}