try{ 
       choice = Integer.parseInt(input.next());
   } 
catch(NumberFormatException e){
    System.out.println("Invalid choice");
    inputIsOk = false;
}