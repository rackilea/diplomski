public List<Flyer> makeFlyerList() {
  return new ArrayList<Flyer>(Arrays.asList(new Airplane(), new Bird()));
}

// works just the same
public List<Flyer> makeFlyerList() {
  return new LinkedList<Flyer>(Arrays.asList(new Airplane(), new Bird()));
}