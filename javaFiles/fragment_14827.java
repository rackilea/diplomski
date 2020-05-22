public enum Items {
  //Fields
  String name;
  AttackSpeed attackSpeed;

  //constructor:
  Items(String name, AttackSpeed attkSpd) {
    this.name = name;
    this.attackSpeed = attkSpd;
  }

  //methods:
  public String getName() {
    return name;
  }

  //listing the instances and calling the constructor:
  StarterBow ("Starter Bow", AttackSpeed.SLOW),
  AdvancedBow ("Advanced Bow", AttackSpeed.MEDIUM),
  GoldenBow ("Golden Bow", AttackSpeed.FAST);
}