public static Map<String, ShipType> ships = new HashMap<String, ShipType>();
// Register ship types
ships.put("wood", new WoodShipType());
// Construct a ship
Ship myShip = new Ship();
myShip.setType(ships.get("wood"));