ExchangeService service = new ExchangeService(ExchangeVersion.Exchange2010_SP2);
                ExchangeCredentials credentials = new WebCredentials("user", "pw");
                service.setCredentials(credentials);
                service.setUrl(new URI("https:// s e r v e r /ews/exchange.asmx"));                    
                EmailAddress mEmail = new EmailAddress("your email / test email");

                EmailMessage message = new EmailMessage(service);
                message.getToRecipients().add(mEmail);
                message.setFrom(mEmail);
                message.setSubject("Hello world!");
                message.setBody(MessageBody.getMessageBodyFromText("Sent using the EWS Android API."));
                message.send();