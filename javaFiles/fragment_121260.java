Income income=new Income();
 IncomeBlock incomeBlock=new IncomeBlock ();
 IncomeDetail incomeDetail=new IncomeDetail ();
 incomeBlock.addIncomeDetail(incomeDetail);
 income.addIncomeBlock(incomeBlock);
 em.persist(income);