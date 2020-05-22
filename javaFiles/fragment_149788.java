public boolean inputLastname(){
   System.out.println("Enter New Employee Information");
   System.out.print("Enter Employee Last Name: ");
   lastName = sc.nextLine();

   Boolean returnBool = true;

   if(lastName.isEmpty()){
       returnBool = false;
       System.out.println("No Employee Information Entered");
       }
   return returnBool;
}