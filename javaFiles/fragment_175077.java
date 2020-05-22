String emailAddress = "xxxxxxxxxxxxxxxxxxxxxxx@developer.gserviceaccount.com";
JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
HttpTransport httpTransport;
try {
    httpTransport = GoogleNetHttpTransport.newTrustedTransport();


    List<String> serviceAccountScopes = new ArrayList<String>();
    serviceAccountScopes.add("https://www.googleapis.com/auth/admin.reports.usage.readonly");
    serviceAccountScopes.add("https://www.googleapis.com/auth/admin.reports.audit.readonly");


    GoogleCredential credential = new GoogleCredential.Builder()
            .setTransport(httpTransport)
            .setJsonFactory(JSON_FACTORY)
            .setServiceAccountId(emailAddress)
            .setServiceAccountUser("user@domain.com")
            .setServiceAccountPrivateKeyFromP12File(new File("xxxxxxxx.p12"))
            .setServiceAccountScopes(serviceAccountScopes).build();


    // Admin SDK API call - Directory

    Reports report_builder = new Reports.Builder(httpTransport, JSON_FACTORY, credential)
        .setApplicationName("xxxxxxxxxxxxxxxxxxxxx.apps.googleusercontent.com")
        .build();

    UsageReports rep =  report_builder.customerUsageReports().get("2015-01-01")
            .setParameters("docs:num_docs").execute();

    UsageReport report = rep.getUsageReports().get(0);      
    Long num_docs = (long) = report.getParameters().get(0).getIntValue();

    System.out.println("There are " + num_docs.toString() + " docs in the domain");

}catch(Exception e){
    //TODO:
    e.printStackTrace();
}