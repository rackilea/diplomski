while(response.charAt(0)=='y')
      {  System.out.println("Enter password")
         String input = sc.nextLine();
         if(input.equalsIgnoreCase("Noah")==true)
         {
            System.out.println("Password correct");
            break;
         }
         else if(input.equalsIgnoreCase("Noah")==false)
         {
            System.out.println("Password incorrect, would you like to try again?");
            response = sc.nextLine();
         }
      }