public class Income {

  private float amount;
...
  public void applyBonus(BonusRule bonusRule){
       float bonus = bonusRule.compute(this);
       amount += bonus;
  }      
...
}