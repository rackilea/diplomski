for (int i = 0; i < messages.length; i++) {
            if ((messages[i].getSubject() != null) && (messages[i].getSubject().contains(subject))) {
                System.out.println(messages[i].getSubject() + "\t"
                        + messages[i].getSentDate());
            } else {
                System.out.println("subject mismatch");
            }
        }