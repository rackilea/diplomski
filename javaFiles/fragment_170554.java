public interface PlayerAttributes {

  PlayerPosition getPlayerPosition(PlayerPosition position);

  Float getAttackPower(Float value);
  Float getDefensePower(Float value);
}

abstract class Player implements PlayerAttributes {

  String name;
  Integer number;

  @Override
  public PlayerPosition getPlayerPosition(PlayerPosition position) {
    return PlayerPosition.DEFENDER;
  }

  @Override
  public Float getAttackPower(Float value) {
    return value * attackPowerMultiplier();
  }

  public Float getDefensePower(Float value) {
    return value * defensePowerMultiplier();
  }

  public abstract Float attackPowerMultiplier();
  public abstract Float defensePowerMultiplier();
}

class Defender extends Player implements PlayerAttributes {
  public static final Float ATTACK_POWER_MUTLIPLIER = 1.2f;
  public static final Float DEFENSE_POWER_MUTLIPLIER = 2.5f;

  @Override public Float attackPowerMultiplier() {
    return ATTACK_POWER_MUTLIPLIER;
  }

  @Override public Float defensePowerMultiplier() {
    return DEFENSE_POWER_MUTLIPLIER;
  }
}

enum PlayerPosition {
  DEFENDER
}