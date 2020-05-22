public enum Nature
{

  MATTER
  {
    public Particle getCounterWeapon()
    {
      return Particle.ANTIPROTON;
    }
  },
  ANTIMATTER
  {
    public Particle getCounterWeapon()
    {
      return Particle.PROTON;
    }
  };

  public abstract Particle getCounterWeapon();

}