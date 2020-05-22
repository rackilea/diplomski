final long REPLY_BY_MS = 24L * 60L * 60L * 1000L; //One day.
MimeMessage msg = new MimeMessage(session);
msg.setHeader("X-Message-Flag", "Follow up");
javax.mail.internet.MailDateFormat md 
        = new javax.mail.internet.MailDateFormat();
final long now = System.currentTimeMillis();
msg.setHeader("Reply-By", md.format(new Date(now + REPLY_BY_MS)));
msg.setSentDate(new Date(now));