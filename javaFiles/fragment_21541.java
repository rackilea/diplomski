enum Prefix {
  ARROGANT ("Arrogant ",20,2), BLOODY("Bloody ",30,0), CURIOUS("Curious ",5, 4);

  public String name = "itemName"; 
  public int damage = 5;
  public int luck = 0;  

  Prefix(String name, int damage, int luck) {
    this.name = name;
    this.damage = damage;
    this.luck = luck;
  }

  ...
}