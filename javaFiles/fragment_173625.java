for (int i = 0; i < myList.size(); i++)
{
  if(i % 10 == 0 && i != 0){
    System.out.println("Press enter to continue...");
    input.nextLine();
  }
  System.out.println(myList.get(i).getName());
}