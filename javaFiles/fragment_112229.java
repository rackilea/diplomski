if(type==1 || type==2){

        Contact contact = null;

        System.out.println("Please enter ContactId : ");
        String contactId = input.nextLine();
        System.out.println("Please enter First Name : ");
        String firstName = input.nextLine();
        System.out.println("Please enter Last Name : ");
        String lastName = input.nextLine();
        System.out.println("Please enter Address : ");
        String address = input.nextLine();
        System.out.println("Please enter Phone Number : ");
        String phoneNumber = input.nextLine();
        System.out.println("Please enter Email Address : ");
        String emailAddress = input.nextLine();

        if(type == 1){
          System.out.println("Please enter Birthday: ");
          String dateofBirth = input.nextLine();
          contact = new PersonalContact(contactId, firstName, lastName, address, phoneNumber, emailAddress, dateofBirth);
        }

        else if(type == 2){

          System.out.println("Please enter Job Title: ");
          String jobTitle = input.nextLine();
          System.out.println("Please enter Organization: ");
          String organization = input.nextLine();
          contact = new BusinessContact(contactId, firstName, lastName, address, phoneNumber, emailAddress, jobTitle, organization);
        }

        // add the new contact
        contacts.add(contact);
        // print out the newly created contact here
        System.out.println(contact.displayContact());
    }