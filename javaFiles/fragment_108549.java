testSecureHouse() {
  Door door = new Door();
  Window window = new Window();
  House house = new House(door, window,
             null, null, null, null);

  house.secure();

  assertTrue(door.isLocked());
  assertTrue(window.isClosed());
}