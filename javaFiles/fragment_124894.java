while (action != 6) {

        printIntro()
        action = getAction();

        switch (action) {

        case 1: {
            contact = readContact()
            contacts.add(contact);

            try {
                writeContact(contact);
                System.out.println("Your contact has been saved.");
            }
            catch (IOException e) {
                e.printStackTrace();        
            }
        }

        break;
        etc.