BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

        try{
            System.out.println("\nPlease type in your shipping address.");
            System.out.println ("This way you can receive what you have ordered.");
            System.out.println ("In this format: Street, City, State, Zipcode\n");

            customerAddress = bufferRead.readLine();
        }catch (Exception e){
            System.out.println("You need to enter in an address.");
        }

        try {
             System.out.println("Please enter in your telephone number:\n");
             phoneNumber =  bufferRead.readLine();
        }catch (Exception e){
             System.out.println("You need to enter in a phone number.");
        }  


        System.out.println(customerAddress + " " + phoneNumber);