public class Incomes {
  List<Income> incomes = ...
  ....
  public void applyBonus(BonusRule bonusRule){
     for (Income income : incomes){
       income.applyBonus(bonusRule);
     }      
}