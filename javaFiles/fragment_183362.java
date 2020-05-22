List<String> hostnames = new ArrayList<>();
if(remoteFlag && secondaryFlag) {
    hostnames.add(hostname1);
    hostnames.add(hostname2);

} else if …

for (String hostname : hostnames) {
    if(hostname == null) {
        continue;

    }
    try {
        String url = generateURL(hostname1);            
        response = restTemplate.getForObject(url, String.class);
        break;

    } catch(Exception ex) {
        ex.printStackTrace(); // use logger

    }
}
if (response == null) {
    // do error handling

}
return new ClientResponse(response, ClientError.NONE, ClientStatus.SUCCESS);