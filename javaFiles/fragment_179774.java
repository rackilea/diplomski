for (Message incomingMessage : messageInitRequest.getMessageList()) {

        if (incomingMessage instanceof EmailMessage) {

            EmailMessage emailMessage = (EmailMessage) incomingMessage;

            System.out.println("Type: Email");
            System.out.println(emailMessage.getMessageBody());
            System.out.println(emailMessage.getSubject());

        } else if (incomingMessage instanceof SMSMessage) {

            SMSMessage smsMessage = (SMSMessage) incomingMessage;

            System.out.println("Type: SMS");
            System.out.println(smsMessage.getMessageBody());
        }

    }