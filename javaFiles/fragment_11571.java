rule 'age less than 30 do not accept'
  ruleflow-group 'ageKnockoutGroup'
  dialect "mvel"
  when
    loanApplication : LoanApplication(age < 30);
    //process : WorkflowProcessInstance();
    //loanApp : LoanApplication() from (LoanApplication)process.getVariable("loanApplication");
    //eval (loanApp.getAge() < 30);
  then
    loanApplication.setAccepted(false);
    loanApplication.addKnockoutReason("age under 30");
    System.out.println("in then less than 30 with loanApp:" + loanApplication.toString());
    String knockoutReasonFact = "age under 30";
    boolean acceptedFact = false;
    insert(knockoutReasonFact);
    insert(acceptedFact);
    update(loanApplication);
end