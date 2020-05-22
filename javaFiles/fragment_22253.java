private void deleteEmployee(){

  Scanner scan = new Scanner(System.in);
  System.out.println("Enter the first name of the employee you want to delete from the list")
  String name = scan.nextLine();

  for (int i = 0; i < employees.length; i++) {
       if (employee[i] != null && employees[i].getFirstName().equals(name)){
           employees[i] = null;
         break; 
       }

       if (i == employees.length - 1) {
           System.out.println("That requested person is not employed at this firm.")
  }
}