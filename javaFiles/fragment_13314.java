public static void createJobId(String keyStorePath, String keyStorePassword, String subscriptionId)
            throws UnrecoverableKeyException, KeyManagementException, KeyStoreException, NoSuchAlgorithmException,
            IOException {
        String automationName = <auto_account_name>;
        String jobId=java.util.UUID.randomUUID().toString();
        String url = String.format(
                "https://management.core.windows.net/%s/cloudServices/ OaaSCSI6EGAZU6F6QTCK5XRVT45FKJC6RC7IQIQW3OPR7SVLE4ZPD4IQQQ-East-US/resources/automation/~/automationAccounts/%s/jobs/%s?api-version=2014-12-08",
                subscriptionId, automationName, jobId);
        System.out.println("URL: "+url);
        String requestBody = "{ \"properties\":{ \"runbook\":{ \"name\":\"<RUNBOOK_NAME>\" } } }";
        int createResponseCode = processPutRequest(new URL(url), requestBody.getBytes(), "application/json",
                keyStorePath, keyStorePassword);
        System.out.println("JOB created :: " + createResponseCode);
    }