ArrayList  accts = new ArrayList();

String acct1 = data.getAccountId1();
String acct2 = data.getAccountId2();

accts.add(new LabelValueBean(acct1, acct1));
accts.add(new LabelValueBean(acct2, acct2));

session.setAttribute(WorkConstants.TEST1,accts);