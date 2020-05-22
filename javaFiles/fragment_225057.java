roomA = new Room();
...
roomD = new Room();
roomA.setExit(Direction.SOUTH, roomD);
roomA.setExit(Direction.EAST, roomB);
roomB.setExit(Direction.EAST, roomC);
roomB.setExit(Direction.WEST, roomA);
... and so on