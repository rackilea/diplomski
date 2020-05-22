LocalDateTime currentTime;
public Email(String to, String cc, String bcc, String subject, String body) {
super();
this.to = to;
this.cc = cc;
this.bcc = bcc;
this.subject = subject;
this.body = body;
this.currentTime = LocalDateTime.now();