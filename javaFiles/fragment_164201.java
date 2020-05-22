public static void viewAllFruit(ArrayList<String> fruits, String CustomerRef[])
  {
for (String fruit : fruits) {
    System.out.println("Fruit " + fruit + " is in stock ");   
}
  }

 public static void reserveFruit(ArrayList<String> fruits,String  CustomerRef[])
{

    Scanner input = new Scanner(System.in);

   while(true) {
    System.out.println("Please enter the name of the fruit you'd like to reserve");
    String Fruitn = input.next();
int index = fruits.indexOf(Fruitn);//added this line
    if (index>=0)// added this condition
    {
        String fruit = fruits.get(index); //added this line
    System.out.println("Reversed Fruit:"+fruit); // do according to your requirement
    }
  }
}
}