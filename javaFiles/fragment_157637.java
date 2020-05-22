public static void newRecord()
{
    System.out.println("Enter your full name: ");
    name = input.nextLine();

    System.out.println("Enter your age: " );
    age = input.nextInt();

    System.out.println("Enter your id: ");
    id = input.nextInt();

    System.out.println(id);

    if(checkID())
    {
      start();
    }
    else
    {
        addRecords();
    }
}