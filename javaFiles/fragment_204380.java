MailSender mockSender = mock(MailSender.class);
YourSMTPServer server = new YourSMTPServer(mockSender);

when(mockSender.send(...)).thenThrow(new MailSendException(...));

// then invoke the method on your server that calls MailSender.send() and
// assert it does what you want it to do when an exception is encountered