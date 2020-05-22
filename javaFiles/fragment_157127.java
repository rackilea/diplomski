if (toAddress!= null) {
    List<String> emails = new ArrayList<>();
    if (toAddress.contains(",")) {
        emails.addAll(Arrays.asList(toAddress.split(",")));
    } else {
        emails.add(toAddress);
    }
    Address[] to = new Address[emails.size()];
    int counter = 0;
    for(String email : emails) {
        to[counter] = new InternetAddress(email.trim());
        counter++;
    }
    message.setRecipients(Message.RecipientType.TO, to);
}