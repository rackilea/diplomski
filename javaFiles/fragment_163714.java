IDataService dataservice = (IDataService) Platform.getPlatform.lookupService(IDataService.class);

        ITransactionService transactionservice = (ITransactionService ) Platform.getPlatform.lookupService(ITransactionService.class);

        PObject workItem = (PObject)dataservice.createInstance("WorkItem");
        workItem.getData().setValue("project","<project-URI>");
        workItem.getData().setValue("title","This is OpenAPI WorkItem");

        try{
         transactionservice.beginTx();
         workItem.save();

        } catch(Exception e){}