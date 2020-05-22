String expe= "Dear testUser testUser,"
            + "You have been registered in the Request Management System. "
            + "Your username is the email address to which this notification is addressed. "
            + "Please click the link below to set your password: http://www.example.com/QA/ChangePassword.aspx?userName=example@yopmail.com&tempPassword=b0cb6ca7-2e52-4b80-8252-f5dac499cea3"
            + "You will receive further information from the our employee that has registered you in the system."
            + "Thank you";


        String[] parts = expe.split("your password: ");
        String part2 = parts[1]; 
        parts = part2.split("You will receive further information");
        part2 = parts[0]; 
        System.out.println(part2);