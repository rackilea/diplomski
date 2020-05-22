Smartlist smartlist=new Smartlist();
 smartlist.setName("SmartList");

 AccountEmailing accountEmailing=new AccountEmailing();
 accountEmailing.setName("AccountEmailing");

 smartlist.addAccountEmail(accountEmailing);

 smartListRepo.saveAndFlush(smartlist);