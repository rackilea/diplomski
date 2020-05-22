List<UserPhoneBook> userPhoneBooks= composeSMSList.getUserPhoneBooks();
       for(UserPhoneBook upb: userPhoneBooks)
        {
            System.out.println("UserPhoneBook id: " + upb.getId());
            System.out.println("UserPhoneBook nrOfContacts: " +upb.getNrOfContacts());
            System.out.println("UserPhoneBook phonebookGroupname: " +upb.getPhonebookGroupname());
        }