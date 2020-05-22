public Flat() {
  super();
  rooms = new Room[0];

  // append the newly created flat into the flats array
  flats = Arrays.copyOf(flats, flats.length + 1);
  flats[flats.length - 1] = this;
}