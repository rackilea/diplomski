Address[] ia = new InternetAddress[toIds.length];
            int i = 0;
            for (String address : toIds) {
                ia[i] = new InternetAddress(address);
                i++;
            }

            message.addRecipients(RecipientType.TO, ia);