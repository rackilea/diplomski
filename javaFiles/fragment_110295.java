GoogleCredential cred = new GoogleCredential().setFromTokenResponse(tokenResponse);

Plus plus = new Plus.Builder(TRANSPORT, JSON_FACTORY, cred)
    .setApplicationName(APPLICATION_NAME).build();

Person person = plus.people().get("me").execute();          
List<Emails> emails = person.getEmails();

String name = person.getDisplayName();
String emailAddr = emails.get(0).getValue();