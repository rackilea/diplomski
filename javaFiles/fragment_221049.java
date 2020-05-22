public class Hero
{
  public HeroType Type { get; set; }
  public int Power { get; set;}

  public Hero(HeroType type, int power){
      this.Type = type;
      this.Power = power;
  }

  ....
}