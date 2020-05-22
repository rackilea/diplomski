List<Recipient> recipientList = new ArrayList<Recipient>(email.getRecipients());
email.setRecipients(new ArrayList<Recipient>());
 for (Recipient recipient : recipientList) {
        recipient.getEmails().add(email);
          email.getRecipients().add(email);
         Recipient persistedRecipient = recipientRepository.save(recipient);

         email = persistedRecipient.getEmails().get(persistedRecipient.getEmails().size()-1);//get the managed email
    }