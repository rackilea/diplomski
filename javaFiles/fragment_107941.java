@Autowired
private MailSender secondMailSender;

@Autowired
private MailSender firstMailSender;

try {
  firstMailSender.send(message);     // send mail....
} catch (MailException e) {
  LOG.debug("Unable to sendmail " + e.getMessage());
  try {
    secondMailSender.send(message); 
    ....
}