List<A> mixed = new ArrayList<A>();
mixed.addAll(listOfA);
mixed.addAll(listOfB);

for (A item : mixed) {
  item.methodA();
}