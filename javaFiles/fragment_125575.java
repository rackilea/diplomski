class AClass
{
  @Inject private Game game;
  void method() {
    Weapon weapon = game.createItem(AK47.class);
    weapon.shoot();
  }
}