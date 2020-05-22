HtmlEmail email = new HtmlEmail();

email.setHostName(mailserver);
email.setAuthentication(username, password);
email.setSmtpPort(port);
email.setFrom(fromEmail);
email.addTo(to);
email.setSubject(subject);

email.setTextMsg(textBody);
email.setHtmlMsg(htmlBody);

email.setDebug(true);

email.send();