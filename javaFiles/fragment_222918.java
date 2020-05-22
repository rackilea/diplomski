try {
        // create a multipart
        StringBuffer sbFileBody = new StringBuffer();
        Multipart mp = new Multipart();
        TextBodyPart tbp = new TextBodyPart(mp, "your message body");
        SupportedAttachmentPart sap = new SupportedAttachmentPart(mp, "text/plain", "info.txt", sbFileBody.toString().getBytes("UTF-8"));
        mp.addBodyPart(tbp);
        mp.addBodyPart(sap);

        ServiceConfiguration sc = null;
        ServiceRecord[] records = ServiceBook.getSB().getRecords();
        for (int i = 0; i < records.length; i++) {
            if (records[i].getCid().equalsIgnoreCase("CMIME") && !records[i].isDisabled() && records[i].isValid()) {
                ServiceConfiguration sct = new ServiceConfiguration(records[i]);
                String mailAddress = sct.getEmailAddress().toLowerCase();
                if (mailAddress.equals("from@address.com")) {
                    //use sc;
                    sc = sct;
                    break;
                }
            }
        }
        if (sc != null) {

            Session session = Session.getInstance(sc);
            Store store = session.getStore();
            Folder[] folders = store.list(Folder.SENT);
            Folder sentfolder = folders[0];

            if (sentfolder != null) {
                Message message = new Message(sentfolder);
                Address toAdress = new Address("to@address.com", "to address");
                message.setFrom(new Address(sc.getEmailAddress(), sc.getName()));
                message.addRecipients(Message.RecipientType.TO, new Address[] { toAdress });
                message.setSubject("Your mail subject");
                message.setContent(mp);
                message.addMessageListener(new MessageListener() {
                    public void changed(MessageEvent e) {
                        if (e.getMessage().getStatus() == Message.Status.TX_SENT) {
                            try {
                                e.getMessage().removeMessageListener(this);
                                System.out.println("Send complete");
                            } catch (Exception ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                Transport.send(message);

            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }