void foo(){   
  // create a domain object that has both behavior and data
  Incomes incomes = ...; 
  // invoke a functional method on the object by passing another domain object
  incomes.applyBonus(new ChristmasBonusRule()); 
}