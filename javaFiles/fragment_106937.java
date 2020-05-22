stepOrExpected[i][k] = "Step";
Action[i][k] = ObjectType.getAttribute(StepLstNode,"Action");
RefObj[i][k] = ObjectType.getAttribute(StepLstNode,"RefObj");
Val[i][k] = ObjectType.getAttribute(StepLstNode,"Val");   
System.out.println(i);
System.out.println(k);
System.out.println(ObjectType.getAttribute(StepLstNode,"Action"));
System.out.println(stepOrExpected[i][k]);
stepCountInTC++; //moved counter
k++; //moved counter