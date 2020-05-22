public class IncomeBonusService {
  // stateless : no incomes data inside it
  ....
  public void applyChristmasBonus(List<Income> incomes){
     for (Income income : incomes){
       // Christmas bonus computation here
       float bonus = ...
       income.setAmount(bonus + income.getAmount());
     }
  }
}