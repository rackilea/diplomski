public void getEmailId() throws Exception {
    init();
    NameResolutionCollection nameResults = exchangeService.resolveName("royran");
    Map<String, String> results = new TreeMap<String, String>();
    for (NameResolution name : nameResults) {
        String contactName = name.getMailbox().getName();
        String emailAddress = name.getMailbox().getAddress();
        results.put(contactName, emailAddress);
    }

    for (Map.Entry<String, String> entry : results.entrySet())
    { 
        System.out.println(entry.getKey() + "/" + entry.getValue());
    } 
}