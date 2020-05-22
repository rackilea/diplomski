class AClass
{ 
  @Inject private Provider<AK47> ak47Provider;
  void method() {
    Weapon weapon = ak47Provider.get();
    weapon.shoot();
  }
}