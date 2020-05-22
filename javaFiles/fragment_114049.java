...

    CountDownLatch latch = new CountDownLatch(2);


    new Thread(new Runnable() {
        public void run() {
            caseNum1= new CaseHelper(new ConfigurationService(),new CaseService()).getNextCaseNumberFromDatabase(tenantId);
            Case tempCase = new Case();
            tempCase.setCaseStatusCode(new CodeService().getCodeForKeyGroup("ACTIVE","CASE_STATUS"));
            caseService.saveCase(tempCase, tenantId);
            latch.countDown();
        }
    }).start();

    new Thread(new Runnable() {
        public void run() {
            caseNum2 = new CaseHelper(new ConfigurationService(),new CaseService()).getNextCaseNumberFromDatabase(tenantId);
            latch.countDown();

        }
    }).start();

    latch.await();

    ...