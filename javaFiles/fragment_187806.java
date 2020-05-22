enum ShipType
{
  BATTLE_STAR("battlestar"),
  BATTLE_CRUISER(battlecruiser"),
  BATTLE_SHOOTER("battleshooter",

  public final String name;

  private ShipType(String name) { this.name = name; }
}

class SpaceShip
{
  ShipType type;
  ...
}