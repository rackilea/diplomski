public void saveEmail(EmailDTO emailDTO) {
//Save to the db
final Email myEmail = new Email();
myEmail .copyFrom(emailDTO);
for (Recipient recipient : myEmail.getRecipients()) {
    recipient.getEmails().add(myEmail );

}

emailRepository.save(myEmail );